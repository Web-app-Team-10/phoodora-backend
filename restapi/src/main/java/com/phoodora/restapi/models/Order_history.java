package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "order_history")
public class Order_history {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "history_id")
    public int id;

    @Column(name = "date")
    public String date;

    @Column(name = "total_cost")
    public double total_cost;

    @Column(name = "items")
    public String items;

    @Column(name = "restaurant")
    public String restaurant;

    public Order_history() {}

    public Order_history(int history_id) {

        this.id = history_id;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));

        return builder.toString();
    }
}
