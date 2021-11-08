package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Restaurant;
import com.phoodora.restapi.services.AppService;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    AppService service;
    
    @GetMapping("/restaurant")
    public List<Restaurant> getAllrestaurant() {
        return service.findAllRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/restaurant")
    public String addRestaurant(@RequestBody Restaurant Restaurant) {

        if(Restaurant != null) {
            service.insert(Restaurant);
            return "Added a Restaurant";
        } else {
            return "Request does not contain a body";
        }
    }

    @DeleteMapping("restaurant/{id}")
    public String deleteRestaurant(@PathVariable("id") int id) {

        if(id > 0) {
            if(service.delete(id)) {
                return "Deleted the Restaurant.";
            } else {
                return "Cannot delete the Restaurant.";
            }
        }
        return "The id is invalid for the Restaurant.";
    }

    @PutMapping("/restaurant")
    public String updateRestaurant(@RequestBody Restaurant Restaurant) {
        if(Restaurant != null) {
            service.update(Restaurant);
            return "Updated Restaurant.";
        } else {
            return "Request does not contain a body";
        }
    }
}
