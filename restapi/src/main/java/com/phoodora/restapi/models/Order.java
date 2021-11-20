package com.phoodora.restapi.models;

import java.security.Timestamp;
import javax.persistence.*;
import org.json.simple.JSONArray;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_id")
    public int id;

    @Column(name = "order_data")
    public JSONArray order_data;

    @Column(name = "eta")
    public Timestamp eta;

    @Column(name = "received")
    public boolean received;

    @Column(name = "preparing")
    public boolean preparing;

    @Column(name = "waiting")
    public boolean waiting;

    @Column(name = "delivering")
    public boolean delivering;

    @Column(name = "delivered")
    public boolean delivered;

    @Column(name = "users_id")
    public int users_id;

    @Column(name = "restaurant_id")
    public int restaurant_id;

    public Order() {}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(id));
        return builder.toString();
    }
}
