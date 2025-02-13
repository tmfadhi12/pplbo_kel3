package com.thowan.microservices.service;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.thowan.microservices.dto.OrderRequest;
import com.thowan.microservices.model.Order;
import com.thowan.microservices.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        orderRepository.save(order);
    }

}