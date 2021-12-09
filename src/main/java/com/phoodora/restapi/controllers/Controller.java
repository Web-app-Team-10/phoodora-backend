package com.phoodora.restapi.controllers;

import com.phoodora.restapi.services.AppService;
import com.phoodora.restapi.repositories.UsersRepository;

import com.phoodora.restapi.models.Order;
import com.phoodora.restapi.models.Product;
import com.phoodora.restapi.models.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
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
        public List<Object> getRestaurant(@PathVariable int id) {
            List<Object> restaurantWithMenu = new ArrayList<>();
            Restaurant restaurant = service.findByIdRestaurant(id);
            List<Product> product = service.findAllRestaurantProducts(id);
            restaurantWithMenu.add(restaurant);
            restaurantWithMenu.add(product);
            return restaurantWithMenu;
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

        // PRODUCT MAPPINGS
        @PostMapping("/admin/product")
        public Product addProduct(@RequestBody JSONObject product) {
            return service.insertToProduct(product);
        }

        @DeleteMapping("/admin/product/{id}")
        public String deleteProduct(@PathVariable int id) {
            service.deleteProduct(id);
            return "Deleted the Product.";
        }

        // ORDER MAPPINGS
        @GetMapping("/orders")
        public List<Order> getAllUsersOrders() {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.findAllUsersOrders(users_id);
        }
}
