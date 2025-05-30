package com.example.shop.infrastructure.controller;

import com.example.shop.domain.service.OrderService;
import com.example.shop.infrastructure.dto.BuyerDTO;
import com.example.shop.infrastructure.dto.OrderDTO;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/{cartId}")
    public OrderDTO placeOrder(@PathVariable UUID cartId, @RequestBody BuyerDTO buyerDto) {
        throw new RuntimeException("not implemented yet");
    }
}