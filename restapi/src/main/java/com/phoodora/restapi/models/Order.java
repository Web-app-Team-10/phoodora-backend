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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public JSONArray getOrder_data() {
        return this.order_data;
    }

    public void setOrder_data(JSONArray order_data) {
        this.order_data = order_data;
    }

    public Timestamp getEta() {
        return this.eta;
    }

    public void setEta(Timestamp eta) {
        this.eta = eta;
    }

    public boolean isReceived() {
        return this.received;
    }

    public boolean getReceived() {
        return this.received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }

    public boolean isPreparing() {
        return this.preparing;
    }

    public boolean getPreparing() {
        return this.preparing;
    }

    public void setPreparing(boolean preparing) {
        this.preparing = preparing;
    }

    public boolean isWaiting() {
        return this.waiting;
    }

    public boolean getWaiting() {
        return this.waiting;
    }

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    public boolean isDelivering() {
        return this.delivering;
    }

    public boolean getDelivering() {
        return this.delivering;
    }

    public void setDelivering(boolean delivering) {
        this.delivering = delivering;
    }

    public boolean isDelivered() {
        return this.delivered;
    }

    public boolean getDelivered() {
        return this.delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public int getUsers_id() {
        return this.users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getRestaurant_id() {
        return this.restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }
}
