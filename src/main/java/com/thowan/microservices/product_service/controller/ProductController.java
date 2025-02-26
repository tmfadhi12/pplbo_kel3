package com.thowan.microservices.product_service.controller;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators.In;
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
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    // @ResponseStatus(HttpStatus.OK)
    // public List<Product> getAllProducts() {
    //     try {
    //         Thread.sleep(5000);
    //     } catch (InterruptedException e) {
    //         throw new RuntimeException(e);
    //     }
    //     return productService.getAllProducts();
    // }
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}