package com.phoodora.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* USED FOR Postgre QUERIES FOR NOW
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
*/

@SpringBootApplication
public class Application {
     
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
