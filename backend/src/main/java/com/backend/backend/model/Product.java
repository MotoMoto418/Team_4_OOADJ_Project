package com.backend.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class Product {
    @Setter
    @Getter
    private int id;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private BigDecimal price;

    @Setter
    @Getter
    private int seller_id;

    @Setter
    @Getter
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

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", seller_id=" + seller_id +
                ", buyer_id=" + buyer_id +
                ", how_old=" + how_old +
                ", images=" + images +
                ", category" + category +
                '}';
    }

    public Product(int id, String name, String description, BigDecimal price, int seller_id, int buyer_id, String how_old, String images, int category) {
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

    public Product() {
    }
}
