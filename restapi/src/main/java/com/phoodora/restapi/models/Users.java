package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "users_id")
    public int id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    @Column(name = "user_type")
    public boolean user_type;

    public Users() {}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(username);
        return builder.toString();
    }
}
