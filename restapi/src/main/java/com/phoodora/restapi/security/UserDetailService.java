package com.phoodora.restapi.security;

import com.phoodora.restapi.interfaces.IUserDetailService;
import com.phoodora.restapi.models.Users;
import com.phoodora.restapi.repositories.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements IUserDetailService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users loadUserByUsername(String username) throws UsernameNotFoundException { 
        Users user = usersRepository.findByUsername(username);
        return user; 
    }

    public void createUser(Users user) { 
        usersRepository.save((Users) user); 
    } 
}

