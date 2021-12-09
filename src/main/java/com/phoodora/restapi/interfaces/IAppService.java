package com.phoodora.restapi.interfaces;

import java.util.List;

import com.phoodora.restapi.models.Order;
import com.phoodora.restapi.models.Restaurant;

import org.json.simple.JSONObject;

public interface IAppService {

    // Required order methods
    List<Order> findAllUsersOrders(int id);
    Order findByIdOrder(int id);
    Order insertToOrder(Order p);
    boolean updateOrder(Order p);

    // Required restaurant methods
    List<Restaurant> findAllRestaurants();
    List<Restaurant> findAllUsersRestaurants(int id);
    Restaurant findByIdRestaurant(int id);
    Restaurant insertToRestaurant(JSONObject p, int users_id);
    boolean deleteRestaurant(int id);
    // boolean updateRestaurant(JSONObject p);
}
