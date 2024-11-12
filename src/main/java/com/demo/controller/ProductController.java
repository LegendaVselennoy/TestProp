package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/sum/{status}")
    public BigDecimal sumListStatus(@PathVariable String status) {
        return productService.sumByPriceStatus(status);
    }

    @GetMapping("/one/{id}")
    public Optional<Product> getProduct(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/{status}")
    public List<Product> getProductsByStatus(@PathVariable String status) {
        return productService.findProductByStatusList(status);
    }

    @GetMapping("/sellable")
    public BigDecimal getProductsSumWhereStatusSellable() {
        return productService.sumByStatus();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product product) {
        return productService.udateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAll();
    }
}
