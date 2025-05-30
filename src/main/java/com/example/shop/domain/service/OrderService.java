package com.example.shop.domain.service;

import com.example.shop.domain.model.*;
import com.example.shop.domain.repository.CartRepository;
import com.example.shop.domain.repository.OrderRepository;

import java.util.UUID;

public class OrderService {
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public Order placeOrder(UUID cartId, Buyer buyer) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();
        UUID orderId = UUID.randomUUID();
        Order order = new Order(orderId, cart.getItems(), buyer);
        orderRepository.save(order);
        return order;
    }
}