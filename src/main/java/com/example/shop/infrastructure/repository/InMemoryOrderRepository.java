package com.example.shop.infrastructure.repository;

import com.example.shop.domain.model.Order;
import com.example.shop.domain.repository.OrderRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryOrderRepository implements OrderRepository {
    private final Map<UUID, Order> orders = new HashMap<>();

    public void save(Order order) {
        orders.put(order.getId(), order);
    }
}