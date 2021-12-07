package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import com.phoodora.restapi.security.UserDetails;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.json.simple.JSONObject;

@RestController
public class LoginController {
    
    @Autowired
    private UserDetails userDetailsService;

    @GetMapping("/login")
    public String login() {  
       return "login";
    }

    @GetMapping("/register") 
    public String register() {  
       return "register";
    } 

    @PostMapping("/register/customer")
    public void addCustomer(@RequestBody JSONObject input) {
       Users user = new Users();
       user.setUsername((String) input.get("username")); 
       user.setPassword((String) input.get("password"));
       userDetailsService.createCustomer(user);
    }

    @PostMapping("/register/manager")
    public void addManager(@RequestBody JSONObject input) {
       Users user = new Users();
       user.setUsername((String) input.get("username")); 
       user.setPassword((String) input.get("username"));
       userDetailsService.createManager(user);
    }
}
