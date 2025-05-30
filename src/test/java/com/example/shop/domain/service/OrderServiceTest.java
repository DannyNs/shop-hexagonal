package com.example.shop.domain.service;

import com.example.shop.domain.model.*;
import com.example.shop.domain.repository.CartRepository;
import com.example.shop.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private OrderService orderService;
    private UUID cartId;
    private Cart cart;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        cartRepository = mock(CartRepository.class);
        orderService = new OrderService(orderRepository, cartRepository);
        cartId = UUID.randomUUID();
        cart = new Cart(cartId);
        Product product = new Product(UUID.randomUUID(), "Book", new BigDecimal("10.00"));
        cart.addProduct(product, 1);
    }

    @Test
    void shouldPlaceOrderFromCart() {
        Buyer buyer = new Buyer("John", "Doe", new Address("Street 1", "City", "12345"));
        when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));

        Order order = orderService.placeOrder(cartId, buyer);

        assertNotNull(order);
        verify(orderRepository).save(any(Order.class));
    }
}
