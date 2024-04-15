package com.backend.backend.service;

import com.backend.backend.entity.ProductEntity;
import com.backend.backend.model.Product;
import com.backend.backend.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{

    private ProductRepository productRepository;

    public ProductsServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAvailableProducts() {
        List<ProductEntity> productEntities = productRepository.findByBuyerIdIsSellerId();
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(product, productEntity);
        productRepository.save(productEntity);
        return product;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        return productEntityOptional.map(this::convertToProduct).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);
        if (productEntityOptional.isPresent()) {
            ProductEntity existingProductEntity = productEntityOptional.get();
            existingProductEntity.setBuyer_id(product.getBuyer_id());
            productRepository.save(existingProductEntity);
            return convertToProduct(existingProductEntity);
        } else {
            return null; // Or throw exception if required
        }
    }

    @Override
    public List<Product> getProductsByBuyerId(int userId) {
        List<ProductEntity> productEntities = productRepository.findByBuyerId(userId);
        return convertToProductList(productEntities);
    }

    @Override
    public List<Product> getProductsBySellerId(int userId) {
        List<ProductEntity> productEntities = productRepository.findBySellerId(userId);
        return convertToProductList(productEntities);
    }

    private List<Product> convertToProductList(List<ProductEntity> productEntities) {
        List<Product> products = new ArrayList<>();
        for (ProductEntity productEntity : productEntities) {
            Product product = new Product();
            BeanUtils.copyProperties(productEntity, product);
            products.add(product);
        }
        return products;
    }

    private Product convertToProduct(ProductEntity productEntity) {
        Product product = new Product();
        BeanUtils.copyProperties(productEntity, product);
        return product;
    }
}
