package com.example.shop.domain.model;

public class CartItem {
    private final Product product;
    private final Integer amount;

    public CartItem(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() { return product; }
    public Integer getAmount() { return amount; }
}