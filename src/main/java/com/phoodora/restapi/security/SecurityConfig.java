// package com.phoodora.restapi.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     UserDetails userDetailsService;

//     @Autowired
//     BCryptPasswordEncoder bcrypt;

//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
        
//         http.requiresChannel().requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null).requiresSecure();

//         http.csrf().disable();
//         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//         .logoutSuccessUrl("/logout").deleteCookies("JSESSIONID")
//         .invalidateHttpSession(true);

//         http.authorizeRequests().antMatchers("/admin/**").authenticated();

//         http.authorizeRequests().antMatchers("/manager/**").hasRole("MANAGER").and();

//         http.authorizeRequests().antMatchers("/register**").permitAll();
//         http.authorizeRequests().antMatchers("/public/**").permitAll();

//         http.addFilter(new AuthenticationFilter(authenticationManager()));
//         http.addFilter(new AuthorizationFilter(authenticationManager()));
//     }
// }
