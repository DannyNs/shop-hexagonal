package com.example.shop.domain.service;

import com.example.shop.domain.model.Cart;
import com.example.shop.domain.model.Product;
import com.example.shop.domain.repository.CartRepository;
import com.example.shop.domain.repository.ProductRepository;

import java.util.UUID;

public class CartService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;

    public CartService(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public void addProductToCart(UUID cartId, UUID productId, Integer amount) {
        Product product = productRepository.findById(productId).orElseThrow();
        Cart cart = cartRepository.findById(cartId).orElse(new Cart(cartId));
        cart.addProduct(product, amount);
        cartRepository.save(cart);
    }
}