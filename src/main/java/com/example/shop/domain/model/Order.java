package com.example.shop.domain.model;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final List<CartItem> items;
    private final Buyer buyer;

    public Order(UUID id, List<CartItem> items, Buyer buyer) {
        this.id = id;
        this.items = items;
        this.buyer = buyer;
    }

    public UUID getId() { return id; }
    public List<CartItem> getItems() { return items; }
    public Buyer getBuyer() { return buyer; }
}