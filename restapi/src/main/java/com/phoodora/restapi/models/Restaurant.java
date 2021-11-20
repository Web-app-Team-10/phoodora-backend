package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "restaurant_id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "image")
    public String image;

    @Column(name = "operating_hours")
    public String operating_hours;

    @Column(name = "price_level")
    public String price_level;

    @Column(name = "type")
    public String type;

    @Column(name = "users_id")
    public int users_id;

    public Restaurant() {}

    public Restaurant(String name, String address, String image, String operating_hours, String price_level, String type, int users_id) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.operating_hours = operating_hours;
        this.price_level = price_level;
        this.type = type;
        this.users_id = users_id;
    }

    public Restaurant(int id, String name, String address, String image, String operating_hours, String price_level, String type, int users_id) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.operating_hours = operating_hours;
        this.price_level = price_level;
        this.type = type;
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(address);
        return builder.toString();
    }
}
