package com.phoodora.restapi.services;

import java.util.List;
import java.util.Optional;

import com.phoodora.restapi.interfaces.IAppService;

import com.phoodora.restapi.models.Restaurant;
import com.phoodora.restapi.models.Restaurant_order_history;
import com.phoodora.restapi.models.Restaurant_user;
import com.phoodora.restapi.models.User_credentials;
import com.phoodora.restapi.models.Users;
import com.phoodora.restapi.models.Products;
import com.phoodora.restapi.models.Order_history;
import com.phoodora.restapi.models.Order_status;

import com.phoodora.restapi.repositories.RestaurantRepository;
import com.phoodora.restapi.repositories.Restaurant_order_historyRepository;
import com.phoodora.restapi.repositories.Restaurant_userRepository;
import com.phoodora.restapi.repositories.User_credentialsRepository;
import com.phoodora.restapi.repositories.UsersRepository;
import com.phoodora.restapi.repositories.Order_historyRepository;
import com.phoodora.restapi.repositories.Order_statusRepository;
import com.phoodora.restapi.repositories.ProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService implements IAppService {


    @Autowired
    private RestaurantRepository restaurantRepository;
    
    @Override
    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>)restaurantRepository.findAll();
    }
    
    @Override
    public Restaurant insert(Restaurant p) {
        return restaurantRepository.save(p);
    }
    
    @Override
    public boolean delete(int id) {
        try {
            restaurantRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public Restaurant findById(int id) {
        Optional<Restaurant> result = restaurantRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
    
    @Override
    public boolean update(Restaurant p) {
        try {
            restaurantRepository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
