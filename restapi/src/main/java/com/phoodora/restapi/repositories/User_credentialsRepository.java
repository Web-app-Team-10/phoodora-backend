package com.phoodora.restapi.repositories;

import com.phoodora.restapi.models.User_credentials;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_credentialsRepository extends CrudRepository<User_credentials, Integer> {

}
