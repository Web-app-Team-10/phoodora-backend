package com.phoodora.restapi.controllers;

import com.phoodora.restapi.services.AppService;
import com.phoodora.restapi.repositories.UsersRepository;

import com.phoodora.restapi.models.Order;
import com.phoodora.restapi.models.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.json.simple.JSONObject;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
public class Controller {

    @Autowired
    AppService service;

    @Autowired
    UsersRepository usersRepository;
    
    /* PUBLIC RESTAURANT MAPPINGS */
        @GetMapping("/")
        public List<Restaurant> getAllrestaurant() {
            return service.findAllRestaurants();
        }

        @GetMapping("/restaurants/{id}")
        public Restaurant getRestaurant(@PathVariable int id) {
            return service.findByIdRestaurant(id);
        }

    /* MANAGER RESTAURANT MAPPINGS */
        @GetMapping("/admin/restaurant")
        public List<Restaurant> getAllUsersRestaurant() {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.findAllUsersRestaurants(users_id);
        }

        @PostMapping("/admin/restaurant")
        public Restaurant addRestaurant(@RequestBody JSONObject restaurant) {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.insertToRestaurant(restaurant, users_id);
        }

        @DeleteMapping("/admin/restaurant/{id}")
        public String deleteRestaurant(@PathVariable int id) {
            service.deleteRestaurant(id);
            return "Deleted the Restaurant.";
        }

        @PutMapping("/admin/restaurant")
        public String updateRestaurant(@RequestBody JSONObject Restaurant) {
            if(Restaurant != null) {
                service.updateRestaurant(Restaurant);
                return "Updated Restaurant.";
            } else {
                return "Request does not contain a body";
            }
        }

        // ORDER MAPPINGS
        @GetMapping("/orders")
        public List<Order> getAllUsersOrders() {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.findAllUsersOrders(users_id);
        }
}
