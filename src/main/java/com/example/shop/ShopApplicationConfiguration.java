package com.example.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.shop.domain.repository.CartRepository;
import com.example.shop.domain.repository.OrderRepository;
import com.example.shop.domain.repository.ProductRepository;
import com.example.shop.domain.service.CartService;
import com.example.shop.domain.service.OrderService;

@Configuration
public class ShopApplicationConfiguration {
    @Bean
    public CartService cartService(ProductRepository productRepo, CartRepository cartRepo) {
        return new CartService(productRepo, cartRepo);
    }

    @Bean
    public OrderService orderService(OrderRepository orderRepo, CartRepository cartRepo) {
        return new OrderService(orderRepo, cartRepo);
    }
}
