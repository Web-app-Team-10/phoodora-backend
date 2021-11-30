package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Order;
import com.phoodora.restapi.models.Product;
import com.phoodora.restapi.models.Restaurant;
import com.phoodora.restapi.repositories.UsersRepository;
import com.phoodora.restapi.services.AppService;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    AppService service;

    @Autowired
    UsersRepository usersRepository;

    // ORDER MAPPINGS
        @GetMapping("/admin/orders")
        public List<Order> getAllUsersOrders() {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.findAllUsersOrders(users_id);
        }
    
    // RESTAURANT MAPPINGS
        @GetMapping("/public/restaurants")
        public List<Restaurant> getAllrestaurant() {
            return service.findAllRestaurants();
        }

        @GetMapping("/manager/restaurants/{id}")
        public List<Restaurant> getAllUsersRestaurant() {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.findAllUsersRestaurants(users_id);
        }

        @GetMapping("/public/restaurant/{id}")
        public Restaurant getRestaurant(@PathVariable int id) {
            return service.findByIdRestaurant(id);
        }

        @PostMapping("/manager/restaurant")
        public Restaurant addRestaurant(@RequestBody JSONObject restaurant) {
            String user = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
            int users_id = usersRepository.findByUsername(user).getId();

            return service.insertToRestaurant(restaurant, users_id);
        }

        @DeleteMapping("/manager/restaurant/{id}")
        public String deleteRestaurant(@PathVariable int id) {
            service.deleteRestaurant(id);
            return "Deleted the Restaurant.";
        }


        @PutMapping("/manager/restaurant")
        public String updateRestaurant(@RequestBody JSONObject Restaurant) {
            if(Restaurant != null) {
                service.updateRestaurant(Restaurant);
                return "Updated Restaurant.";
            } else {
                return "Request does not contain a body";
            }
        }

    // PRODUCT MAPPINGS
        @GetMapping("/public/products/{id}")
        public List<Product> getAllRestaurantProducts(@PathVariable int id) {
            return service.findAllRestaurantProducts(id);
        }

        @GetMapping("/manager/product/{id}")
        public Product getProduct(@PathVariable int id) {
            return service.findByIdProduct(id);
        }

        @PostMapping("/manager/product")
        public String addProduct(@RequestBody JSONObject Product) {
            if(Product != null) {
                service.insertToProduct(Product);
                return "Added a product";
            } else {
                return "Request does not contain a body";
            }
        }

        @DeleteMapping("/manager/product/{id}")
        public String deleteProduct(@PathVariable("id") int id) {
            service.deleteProduct(id);
            return "Deleted the Product.";
        }
}
