package com.phoodora.restapi.repositories;

import com.phoodora.restapi.models.Order_history;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_historyRepository extends CrudRepository<Order_history, Integer> {

}
