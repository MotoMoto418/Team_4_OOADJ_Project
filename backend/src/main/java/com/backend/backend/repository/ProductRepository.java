package com.backend.backend.repository;

import com.backend.backend.entity.ProductEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("SELECT p FROM ProductEntity p WHERE p.buyer_id = p.seller_id")
    List<ProductEntity> findByBuyerIdIsSellerId();

    @Query("SELECT p FROM ProductEntity p WHERE p.buyer_id = :buyer_id")
    List<ProductEntity> findByBuyerId(int buyer_id);

    @Query("SELECT p FROM ProductEntity p WHERE p.seller_id = :seller_id")
    List<ProductEntity> findBySellerId(int seller_id);
}
