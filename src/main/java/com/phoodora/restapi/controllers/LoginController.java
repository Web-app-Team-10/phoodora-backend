package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Users;

import org.springframework.beans.factory.annotation.Autowired;

import com.phoodora.restapi.security.UserDetails;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.http.MediaType;

@RestController
public class LoginController {
    
    @Autowired
    private UserDetails userDetailsService;

    @PostMapping(path = "/register/customer", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void addCustomer(Users user) {
         userDetailsService.createUser(user, "CUSTOMER");
    }

    @PostMapping(path = "/register/manager", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void addManager(Users user) {
         userDetailsService.createUser(user, "MANAGER");
    }
}
