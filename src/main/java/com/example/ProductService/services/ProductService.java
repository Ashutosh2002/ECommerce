package com.example.ProductService.services;

import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product) throws CategoryNotFoundException;

    void deleteProduct(Long productId);
}
