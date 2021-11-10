package com.phoodora.restapi.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "user_id")
    public int id;

    @Column(name = "f_name")
    public String f_name;

    @Column(name = "l_name")
    public String l_name;

    @Column(name = "address")
    public String address;

    @Column(name = "postal_code")
    public String postal_code;

    @Column(name = "city")
    public String city;

    @Column(name = "phone_number")
    public String phone_number;

    @Column(name = "email")
    public String email;

    public Users() {}

    public Users(int user_id, String f_name, String l_name) {

        this.id = user_id;
        this.f_name = f_name;
        this.l_name = l_name;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(f_name);
        builder.append(", ");
        builder.append(l_name);

        return builder.toString();
    }
}
