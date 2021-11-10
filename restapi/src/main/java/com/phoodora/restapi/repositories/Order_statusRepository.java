package com.phoodora.restapi.repositories;

import com.phoodora.restapi.models.Order_status;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_statusRepository extends CrudRepository<Order_status, Integer> {

}
