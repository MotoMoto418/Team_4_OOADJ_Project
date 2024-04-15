package com.backend.backend.controller;

import com.backend.backend.model.Product;
import com.backend.backend.model.User;
import com.backend.backend.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    public ProductsController(ProductsService productsService) {

        this.productsService = productsService;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        try {
            List<Product> products = productsService.getAvailableProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve products");
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        try {
            Product createdProduct = productsService.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create product");
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
        try {
            Product product = productsService.getProductById(id);
            if (product != null) {
                return ResponseEntity.ok(product);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve product");
        }
    }

    @PostMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        try {
            Product updatedProduct = productsService.updateProduct(id, product);
            return ResponseEntity.ok(updatedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update product");
        }
    }

    @PostMapping("/products/user")
    public ResponseEntity<Object> getUserTransactions(@RequestBody User user) {
        try {
            int userId = user.getId();
            List<Product> bought = productsService.getProductsByBuyerId(userId);
            List<Product> sold = productsService.getProductsBySellerId(userId);
            Map<String, List<Product>> result = new HashMap<>();
            result.put("bought", bought);
            result.put("sold", sold);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve user transactions");
        }
    }
}
