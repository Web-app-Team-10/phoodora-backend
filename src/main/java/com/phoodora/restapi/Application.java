package com.phoodora.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

    // @Bean 
    // public BCryptPasswordEncoder bCryptPasswordEncoder() {
    //     return new BCryptPasswordEncoder(); 
    // }

    @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/");
			}
		};
	}
     
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
