package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "user_credentials")
public class User_credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id")
    public int id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    public String password;

    public User_credentials() {}

    public User_credentials(int user_id, String username, String password) {

        this.id = user_id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(username);
        builder.append(", ");
        builder.append(password);

        return builder.toString();
    }
}
