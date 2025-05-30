package com.example.shop.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private final UUID id;
    private final List<CartItem> items = new ArrayList<>();

    public Cart(UUID id) {
        this.id = id;
    }

    public UUID getId() { return id; }

    public List<CartItem> getItems() {
        return items;
    }

    public void addProduct(Product product, Integer amount) {
        this.items.add(new CartItem(product, amount));
    }
}