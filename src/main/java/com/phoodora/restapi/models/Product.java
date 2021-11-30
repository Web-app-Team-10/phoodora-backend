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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRestaurant_id() {
        return this.restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
