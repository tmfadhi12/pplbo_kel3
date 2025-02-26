package com.thowan.microservices.service;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.thowan.microservices.client.InventoryClient;
import com.thowan.microservices.dto.OrderRequest;
import com.thowan.microservices.model.Order;
import com.thowan.microservices.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest) {
        // Validate skuCode is not null
        if (orderRequest.skuCode() == null || orderRequest.skuCode().isEmpty()) {
            throw new IllegalArgumentException("SkuCode cannot be null or empty");
        }
        
        // Validate quantity is not null
        if (orderRequest.quantity() == null || orderRequest.quantity() <= 0) {
            throw new IllegalArgumentException("Quantity must be a positive number");
        }
    
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode: " + orderRequest.skuCode() + " is out of stock");
        }
    }

}