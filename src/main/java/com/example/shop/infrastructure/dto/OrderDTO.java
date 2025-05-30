package com.example.shop.infrastructure.dto;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
    public UUID id;
    public List<CartItemDTO> items;
    public BuyerDTO buyer;
}
