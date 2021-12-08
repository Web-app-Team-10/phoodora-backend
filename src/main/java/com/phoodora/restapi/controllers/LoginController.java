package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import com.phoodora.restapi.security.UserDetails;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LoginController {
    
    @Autowired
    private UserDetails userDetailsService;

    @PostMapping("/register/customer")
    public String addCustomer(@RequestBody Users user) {
      if(user.getUsername()!= "" && user.getPassword()!= "") {
         userDetailsService.createUser(user, "CUSTOMER");
         return "Created user";
      }
      else {
         return "The request must contain a body";
      }
    }

    @PostMapping("/register/manager")
    public String addManager(@RequestBody Users user) {
      if(user.getUsername()!= "" && user.getPassword()!= "") {
         userDetailsService.createUser(user, "MANAGER");
         return "Created user";
      }
      else {
         return "The request must contain a body";
      }
    }
}
