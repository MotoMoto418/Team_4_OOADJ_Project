package com.backend.backend.model;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String email;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public User(int id, String email, String name, String password, String phone) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public User() {
    }
}
