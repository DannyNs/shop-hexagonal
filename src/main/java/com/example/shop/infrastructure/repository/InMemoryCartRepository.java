package com.example.shop.infrastructure.repository;

import com.example.shop.domain.model.Cart;
import com.example.shop.domain.repository.CartRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryCartRepository implements CartRepository {
    private final Map<UUID, Cart> carts = new HashMap<>();

    public Optional<Cart> findById(UUID id) {
        return Optional.ofNullable(carts.get(id));
    }

    public void save(Cart cart) {
        carts.put(cart.getId(), cart);
    }
}