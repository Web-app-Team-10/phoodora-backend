package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_user")
public class Restaurant_user {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "restaurant_user_id")
    public int id;

    @Column(name = "restaurant_username")
    public String restaurant_username;

    @Column(name = "password")
    public String password;

    public Restaurant_user() {}

    public Restaurant_user(int restaurant_user_id, String restaurant_username, String password) {

        this.id = restaurant_user_id;
        this.restaurant_username = restaurant_username;
        this.password = password;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(restaurant_username);
        builder.append(", ");
        builder.append(password);

        return builder.toString();
    }
}
