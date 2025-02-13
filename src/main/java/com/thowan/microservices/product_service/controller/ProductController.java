package com.thowan.microservices.product_service.controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.thowan.microservices.product_service.dto.ProductRequest;
import com.thowan.microservices.product_service.dto.ProductResponse;
import com.thowan.microservices.product_service.model.Product;
import com.thowan.microservices.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}