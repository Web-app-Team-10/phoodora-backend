package com.phoodora.restapi.interfaces;

import java.util.List;

import com.phoodora.restapi.models.Restaurant;

public interface IAppService {
    List<Restaurant> findAllRestaurants();
    Restaurant findById(int id);
    Restaurant insert(Restaurant p);
    boolean delete(int id);
    boolean update(Restaurant p);
}
