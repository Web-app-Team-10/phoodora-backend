package com.phoodora.restapi.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "users_id")
    public int id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    public Users() {}

    public Users(String username, String password, String role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(getRole()));
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
