package com.phoodora.restapi.services;

import org.springframework.stereotype.Service;
import com.phoodora.restapi.interfaces.IAppService;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.phoodora.restapi.models.Restaurant;
import com.phoodora.restapi.models.Order;

import com.phoodora.restapi.repositories.RestaurantRepository;
import com.phoodora.restapi.repositories.OrderRepository;

import org.json.simple.JSONObject;

@Service
public class AppService implements IAppService {


    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;
  
    // ORDER METHODS
    @Override
    public List<Order> findAllUsersOrders(int id) {
        List<Order> usersOrders = new ArrayList<>();
        for (Order a : orderRepository.findAll()) {
            if(a.users_id == id) {
                usersOrders.add(a);
            }
        }
        return usersOrders;
    }

    @Override
    public Order findByIdOrder(int id) {
        Optional<Order> result = orderRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Order insertToOrder(Order p) {
        return orderRepository.save(p);
    }

    @Override
    public boolean updateOrder(Order p) {
        try {
            orderRepository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // RESTAURANT METHODS
    @Override
    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>)restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findAllUsersRestaurants(int id) {
        List<Restaurant> usersRestaurants = new ArrayList<>();
        for (Restaurant a : restaurantRepository.findAll()) {
            if(a.users_id == id) {
                usersRestaurants.add(a);
            }
        }
        return usersRestaurants;
    }

    @Override
    public Restaurant findByIdRestaurant(int id) {
        Optional<Restaurant> result = restaurantRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Restaurant insertToRestaurant(JSONObject p, int users_id) {
        String name = (String) p.get("name");
        String address = (String) p.get("address"); 
        String image = (String) p.get("image");
        String operating_hours = (String) p.get("operating_hours");
        String price_level = (String) p.get("price_level");
        String type = (String) p.get("type");

        Restaurant newRestaurant = new Restaurant(name, address, image, operating_hours, price_level, type, users_id);
        return restaurantRepository.save(newRestaurant);
    }

    @Override
    public boolean deleteRestaurant(int id) {
        try {
            restaurantRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateRestaurant(JSONObject p) {
        try {
            int id = (Integer) p.get("restaurant_id");
            String name = (String) p.get("name");
            String address = (String) p.get("address"); 
            String image = (String) p.get("image");
            String operating_hours = (String) p.get("operating_hours");
            String price_level = (String) p.get("price_level");
            String type = (String) p.get("type");
            int users_id = (Integer) p.get("users_id");
    
            Restaurant newRestaurant = new Restaurant(id, name, address, image, operating_hours, price_level, type, users_id);
            restaurantRepository.save(newRestaurant);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}    
