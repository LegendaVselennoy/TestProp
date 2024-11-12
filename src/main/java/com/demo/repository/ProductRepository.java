package com.demo.repository;

import com.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByStatus(String status);
    @Query("SELECT sum(p.productValue) from Product p where p.status = 'Sellable'")
    BigDecimal sumProductsWhereStatusSellable();
    @Query("SELECT sum(p.productValue) from Product p where p.status = :status")
    BigDecimal sumWhereStatus(String status);
}
