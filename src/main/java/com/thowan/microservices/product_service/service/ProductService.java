package com.thowan.microservices.product_service.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.thowan.microservices.product_service.dto.ProductRequest;
import com.thowan.microservices.product_service.dto.ProductResponse;
import com.thowan.microservices.product_service.model.Product;
import com.thowan.microservices.product_service.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j


// public class ProductService {

//     private final ProductRepository productRepository;

//     public ProductResponse createProduct(ProductRequest productRequest) {
//         log.info("Creating product {}", productRequest);
//         Product product = Product.builder()
//                 .name(productRequest.name())
//                 .description(productRequest.description())
//                 .price(productRequest.price())
//                 .build();

//         productRepository.save(product);
//         log.info("Product successfully created");
//         return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
//     }

//     public List<ProductResponse> getAllProducts() {
//         List<Product> products = productRepository.findAll();

//         return products.stream().map(this::mapToProductResponse).toList();
//     }

//     private ProductResponse mapToProductResponse(Product product) {
//         return new ProductResponse(product.getId(), product.getName(),
//                 product.getDescription(), product.getPrice());
//     }
// }

public class ProductService{
    private final  ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("Product Successfully created");
        return product;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}