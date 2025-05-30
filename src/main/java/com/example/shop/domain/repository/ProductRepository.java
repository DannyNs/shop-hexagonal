package com.example.shop.domain.repository;

import com.example.shop.domain.model.Product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {
    Optional<Product> findById(UUID id);
    void save(Product product);
}