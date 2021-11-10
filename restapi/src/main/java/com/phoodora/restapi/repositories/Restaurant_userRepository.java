package com.phoodora.restapi.repositories;

import com.phoodora.restapi.models.Restaurant_user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Restaurant_userRepository extends CrudRepository<Restaurant_user, Integer> {

}
