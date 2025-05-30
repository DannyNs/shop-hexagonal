package com.example.shop.infrastructure.repository;

import com.example.shop.domain.model.Product;
import com.example.shop.domain.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final Map<UUID, Product> products = new HashMap<>();

    public InMemoryProductRepository() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        products.put(id1, new Product(id1, "Book", new BigDecimal("10.00")));
        products.put(id2, new Product(id2, "Pen", new BigDecimal("1.50")));
    }

    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    public void save(Product product) {
        products.put(product.getId(), product);
    }
}