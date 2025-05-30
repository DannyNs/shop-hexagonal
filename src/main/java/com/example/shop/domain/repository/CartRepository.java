package com.example.shop.domain.repository;

import com.example.shop.domain.model.Cart;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository {
    Optional<Cart> findById(UUID id);
    void save(Cart cart);
}