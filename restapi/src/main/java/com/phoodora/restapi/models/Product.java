package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    public int id;

    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;

    @Column(name = "price")
    public double price;

    @Column(name = "category")
    public String category;

    @Column(name = "image")
    public String image;

    @Column(name = "restaurant_id")
    public int restaurant_id;

    public Product() {}

    public Product(String name, String description, double price, String category, String image, int restaurant_id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
        this.restaurant_id = restaurant_id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(category);
        return builder.toString();
    }
}
