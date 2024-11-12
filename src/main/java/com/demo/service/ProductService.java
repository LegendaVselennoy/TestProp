package com.demo.service;

import com.demo.model.Product;
import com.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public BigDecimal sumByStatus() {
        return productRepository.sumProductsWhereStatusSellable();
    }

    public List<Product> findProductByStatusList(String status) {
        return productRepository.findProductsByStatus(status);
    }

    public BigDecimal sumByPriceStatus(String status) {
        return productRepository.sumWhereStatus(status);
    }

    public Product udateProduct(Long id,Product product) {
        if (productRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        Product productUpdated = productRepository.findById(id).get();
        productUpdated.setQty(product.getQty());
        productUpdated.setProductValue(product.getProductValue());
        productUpdated.setStatus(product.getStatus());
        productUpdated.setFulfilmentCenter(product.getFulfilmentCenter());
        return productRepository.save(productUpdated);
    }

    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
