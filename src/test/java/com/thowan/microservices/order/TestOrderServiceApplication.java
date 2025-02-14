package com.thowan.microservices.order;

import org.springframework.boot.SpringApplication;

import com.thowan.microservices.OrderServiceApplication;

public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
