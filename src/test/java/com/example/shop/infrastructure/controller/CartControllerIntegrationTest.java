package com.example.shop.infrastructure.controller;

import com.example.shop.domain.model.Product;
import com.example.shop.infrastructure.repository.InMemoryProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CartControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InMemoryProductRepository productRepository;

    private UUID cartId;
    private UUID productId;

    @BeforeEach
    void setup() {
        cartId = UUID.randomUUID();
        productId = UUID.randomUUID();
        Product product = new Product(productId, "Test Product", new BigDecimal("19.99"));
        productRepository.save(product);
    }

    @Test
    void shouldAddProductToCart() throws Exception {
        mockMvc.perform(post("/cart/" + cartId + "/add/" + productId + "/" + 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
