package com.phoodora.restapi.controllers;

import java.util.Map;

import com.phoodora.restapi.models.Users;
import com.phoodora.restapi.security.UserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    
    @Autowired
    private UserDetails userDetailsService;

    @GetMapping("/register") 
    public String register() {  
       return "register";
    } 

    @PostMapping(value = "/register/customer", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public void addCustomer(@RequestParam Map<String, String> body) {
       Users user = new Users();
       user.setUsername(body.get("username")); 
       user.setPassword(body.get("password"));
       userDetailsService.createCustomer(user);
    }

    @PostMapping(value = "/register/manager", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = { MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public void addManager(@RequestParam Map<String, String> body) {
       Users user = new Users();
       user.setUsername(body.get("username")); 
       user.setPassword(body.get("password"));
       userDetailsService.createManager(user);
    }
}
