package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

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

    public Products() {}

    public Products(int product_id, String name, String category) {

        this.id = product_id;
        this.name = name;
        this.category = category;
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
