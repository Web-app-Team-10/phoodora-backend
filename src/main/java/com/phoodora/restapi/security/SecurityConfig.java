package com.phoodora.restapi.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetails userDetailsService;

    @Autowired
    BCryptPasswordEncoder bcrypt;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:3000", "https://phoodora-frontend.herokuapp.com"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "PUT","OPTIONS","PATCH"));
        corsConfiguration.setExposedHeaders(List.of("Authorization"));
        
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/restaurants/**").permitAll()
            .antMatchers("/register/**").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/orders").hasAnyRole("CUSTOMER","MANAGER")
            .antMatchers("/admin/**").hasRole("MANAGER")
            .anyRequest()
            .authenticated();
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.csrf().disable().cors().configurationSource(request -> corsConfiguration);

        http.logout().deleteCookies("JSESSIONID").invalidateHttpSession(true).permitAll();

        http.addFilter(new AuthenticationFilter(authenticationManager()));
        http.addFilter(new AuthorizationFilter(authenticationManager()));
    }
}
