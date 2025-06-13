package com.example.ProductService.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception{

    private Long productId;

    public ProductNotFoundException(){}

    public ProductNotFoundException(Long productId){
        this.productId = productId;
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Long productId){
        super(message);
        this.productId = productId;
    }
}
