package com.phoodora.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "restaurant_id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "address")
    public String address;

    @Column(name = "postal_code")
    public String postal_code;

    @Column(name = "city")
    public String city;

    @Column(name = "operating_hours")
    public String operating_hours;

    @Column(name = "image")
    public String image;

    @Column(name = "type")
    public String type;

    @Column(name = "price_level")
    public String price_level;

    public Restaurant() {}

    public Restaurant(int id, String name, String address) {

        this.id = id;
        this.name = name;
        this.address = address;
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
