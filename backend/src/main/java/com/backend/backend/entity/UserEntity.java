package com.backend.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user")
public class UserEntity {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public UserEntity(int id, String email, String name, String password, String phone) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public UserEntity() {
    }
}
