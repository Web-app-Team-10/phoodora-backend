package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Users;

import org.springframework.beans.factory.annotation.Autowired;
import com.phoodora.restapi.security.UserDetails;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.json.simple.JSONObject;

@RestController
public class LoginController {
    
    @Autowired
    private UserDetails userDetailsService;

    @PostMapping("/register/customer")
    public String addCustomer(@RequestBody JSONObject input) {
      String username = (String) input.get("username");
      String password = (String) input.get("password");
      if(username != "" && password != "") {
         Users user = new Users();
         user.setUsername(username); 
         user.setPassword(password);
         userDetailsService.createUser(user, "CUSTOMER");
         return "Created user";
      }
      else {
         return "The request must contain a body";
      }
    }

    @PostMapping("/register/manager")
    public String addManager(@RequestBody JSONObject input) {
      String username = (String) input.get("username");
      String password = (String) input.get("password");
      if(username != "" && password != "") {
         Users user = new Users();
         user.setUsername(username); 
         user.setPassword(password);
         userDetailsService.createUser(user, "MANAGER");
         return "Created user";
      }
      else {
         return "The request must contain a body";
      }
    }
}
