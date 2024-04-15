package com.backend.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Getter
    private String name;

    @Getter
    @Setter
    private String description;

    @Setter
    @Getter
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Getter
    @Setter
    private int seller_id;

    @Getter
    @Setter
    private int buyer_id;

    public ProductEntity(int id, String name, String description, BigDecimal price, int seller_id, int buyer_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller_id = seller_id;
        this.buyer_id = buyer_id;
    }

    public ProductEntity() {
    }
}
