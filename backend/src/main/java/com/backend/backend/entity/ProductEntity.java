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

    @Getter
    @Setter
    private String how_old;

    @Getter
    @Setter
    private String images;

    @Getter
    @Setter
    private int category;

    public ProductEntity(int id, String name, String description, BigDecimal price, int seller_id, int buyer_id, String how_old, String images, int category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.seller_id = seller_id;
        this.buyer_id = buyer_id;
        this.how_old = how_old;
        this.images = images;
        this.category = category;
    }

    public ProductEntity() {
    }
}
