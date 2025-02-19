package com.thowan.microservices.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    
    @Bean
    public OpenAPI orderServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Order Service API")
                    .description("This is REST API for Order Service")
                    .version("v0.0.1")
                    .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                    .description("You can refer to the Order Service Wiki Documentation")
                    .url("https://order-service-dummy-url.com/docs"));    
    }
}

