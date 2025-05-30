package com.example.shop.infrastructure.controller;

import com.example.shop.domain.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{cartId}/add/{productId}/{amount}")
    public void addProduct(@PathVariable UUID cartId, @PathVariable UUID productId, @PathVariable Integer amount) {
        cartService.addProductToCart(cartId, productId, amount);
    }
}