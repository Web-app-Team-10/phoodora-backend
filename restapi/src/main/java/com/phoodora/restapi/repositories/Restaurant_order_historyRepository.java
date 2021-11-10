package com.phoodora.restapi.repositories;

import com.phoodora.restapi.models.Restaurant_order_history;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Restaurant_order_historyRepository extends CrudRepository<Restaurant_order_history, Integer> {

}
