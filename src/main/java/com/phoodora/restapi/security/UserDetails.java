package com.phoodora.restapi.security;

import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import com.phoodora.restapi.models.Users;
import com.phoodora.restapi.repositories.UsersRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserDetails implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder bcrypt;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException { 
        Users user = usersRepository.findByUsername(username);
            if(user == null) {
                throw new UsernameNotFoundException("User not in database");
            }
            else {
                Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole()));
                return new User(user.getUsername(), user.getPassword(), authorities);
            } 
    }

    public void createCustomer(Users user) {
        user.setPassword(bcrypt.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        usersRepository.save(user);
    } 

    public void createManager(Users user) { 
        user.setPassword(bcrypt.encode(user.getPassword()));
        user.setRole("ROLE_ADMIN");
        usersRepository.save(user);
    } 
}
