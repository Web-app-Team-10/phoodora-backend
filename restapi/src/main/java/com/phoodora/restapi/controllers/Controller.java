package com.phoodora.restapi.controllers;

import com.phoodora.restapi.models.Order;
import com.phoodora.restapi.models.Product;
import com.phoodora.restapi.models.Restaurant;
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

import java.util.List;

@RestController
public class Controller {

    @Autowired
    AppService service;

    // ORDER MAPPINGS
        @GetMapping("/orders/{id}")
        public List<Order> getAllUsersOrders(@PathVariable int id) {
            return service.findAllUsersOrders(id);
        }
    
    // RESTAURANT MAPPINGS
        @GetMapping("/restaurants")
        public List<Restaurant> getAllrestaurant() {
            return service.findAllRestaurants();
        }

        @GetMapping("/restaurants/{id}")
        public List<Restaurant> getAllUsersRestaurant(@PathVariable int id) {
            return service.findAllUsersRestaurants(id);
        }

        @GetMapping("/restaurant/{id}")
        public Restaurant getRestaurant(@PathVariable int id) {
            return service.findByIdRestaurant(id);
        }

        @PostMapping("/restaurant")
        public String addRestaurant(@RequestBody JSONObject Restaurant) {
            if(Restaurant != null) {
                service.insertToRestaurant(Restaurant);
                return "Added a Restaurant";
            } else {
                return "Request does not contain a body";
            }
        }

        @DeleteMapping("restaurant/{id}")
        public String deleteRestaurant(@PathVariable("id") int id) {
            if(id > 0) {
                if(service.deleteRestaurant(id)) {
                    return "Deleted the Restaurant.";
                } else {
                    return "Cannot delete the Restaurant.";
                }
            }
            return "The id is invalid for the Restaurant.";
        }

        @PutMapping("/restaurant")
        public String updateRestaurant(@RequestBody JSONObject Restaurant) {
            if(Restaurant != null) {
                service.updateRestaurant(Restaurant);
                return "Updated Restaurant.";
            } else {
                return "Request does not contain a body";
            }
        }

    // PRODUCT MAPPINGS
        @GetMapping("/products/{id}")
        public List<Product> getAllRestaurantProducts(@PathVariable int id) {
            return service.findAllRestaurantProducts(id);
        }

        @GetMapping("/product/{id}")
        public Product getProduct(@PathVariable int id) {
            return service.findByIdProduct(id);
        }

        @PostMapping("/product")
        public String addProduct(@RequestBody JSONObject Product) {
            if(Product != null) {
                service.insertToProduct(Product);
                return "Added a Restaurant";
            } else {
                return "Request does not contain a body";
            }
        }

        @DeleteMapping("product/{id}")
        public String deleteProduct(@PathVariable("id") int id) {
            if(id > 0) {
                if(service.deleteProduct(id)) {
                    return "Deleted the Product.";
                } else {
                    return "Cannot delete the Product.";
                }
            }
            return "The id is invalid for the Product.";
        }
}
