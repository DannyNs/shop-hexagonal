package com.example.shop.domain.repository;

import com.example.shop.domain.model.Order;

public interface OrderRepository {
    void save(Order order);
}