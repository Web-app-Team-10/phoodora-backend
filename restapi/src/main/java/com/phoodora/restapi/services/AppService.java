package com.phoodora.restapi.services;

import java.util.List;
import java.util.Optional;

import com.phoodora.restapi.interfaces.IAppService;
import com.phoodora.restapi.models.Restaurant;
import com.phoodora.restapi.repositories.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService implements IAppService {

    @Autowired
    private RestaurantRepository repository;
    
    @Override
    public List<Restaurant> findAllRestaurants() {
        return (List<Restaurant>)repository.findAll();
    }
    
    @Override
    public Restaurant insert(Restaurant p) {
        return repository.save(p);
    }
    
    @Override
    public boolean delete(int id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    @Override
    public Restaurant findById(int id) {
        Optional<Restaurant> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
    
    @Override
    public boolean update(Restaurant p) {
        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}
