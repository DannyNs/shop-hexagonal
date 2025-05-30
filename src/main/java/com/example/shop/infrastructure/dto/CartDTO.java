package com.example.shop.infrastructure.dto;

import java.util.List;
import java.util.UUID;

import com.example.shop.domain.model.CartItem;

public class CartDTO {
    public UUID id;
    public List<CartItem> items;
}
