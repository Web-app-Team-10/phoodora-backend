package com.phoodora.restapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService udService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(udService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    //http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

     http 
       .csrf().disable();
    //   .authorizeRequests()
    //   .antMatchers("/register**")
    //   .permitAll()
    //   //.anyRequest().authenticated() 
    //   .and() 
    //   .formLogin().loginPage("/login")
    //   .permitAll() 
    //   .and() 
    //   .logout().invalidateHttpSession(true) 
    //   .clearAuthentication(true).permitAll();

    // http.authorizeRequests().antMatchers("/manager/**").hasAnyAuthority("ADMIN");

    http.authorizeRequests().antMatchers("/public**").permitAll();

    http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("ADMIN");

    http.authorizeRequests().anyRequest().authenticated().and().httpBasic();


    UsernamePasswordAuthenticationFilter authFilter = new Filter();
    authFilter.setAuthenticationManager( this.authenticationManager() );
    http.addFilter(authFilter);
    http.addFilterBefore(new Filter(), UsernamePasswordAuthenticationFilter.class);

    }
}
