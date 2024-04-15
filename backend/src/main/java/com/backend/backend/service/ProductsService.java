package com.backend.backend.service;

import com.backend.backend.model.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAvailableProducts();
    Product createProduct(Product product);

    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);

    List<Product> getProductsByBuyerId(int userId);
    List<Product> getProductsBySellerId(int userId);
}
