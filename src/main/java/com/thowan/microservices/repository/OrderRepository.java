package com.thowan.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thowan.microservices.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
} 
