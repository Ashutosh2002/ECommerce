package com.example.ProductService.controllers;

import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @MockitoBean
    private ProductService productService;

    @Autowired
    private ProductController productController;

    @Test
    public void testGetSingleProductPositiveCase() throws ProductNotFoundException {
//        Arrange
//        Long productId = 10L;
//        Product expectedProduct = new Product();
//
//        expectedProduct.setId(productId);
//        expectedProduct.setTitle("iPhone 16");
//        expectedProduct.setPrice(70000.0);
//
//        when(productService.getSingleProduct(productId)).thenReturn(expectedProduct);

//        Act
//        Product actualProduct = productController.getSingleProduct(productId);

//        Assert
//        assertEquals(expectedProduct, actualProduct);

//        assertEquals(productId, actualProduct.getId());
//        assertEquals("iPhone 16", actualProduct.getTitle());
//        assertEquals(70000.0, actualProduct.getPrice());
    }

    public void testGetSingleProductNegativeCase(){

    }

    @Test
    public void testGetSingleProductThrowsProductNotFoundException() throws ProductNotFoundException {
//        ProductNotFoundException productNotFoundException = new ProductNotFoundException("Please pass the correct productId");
//        when(productService.getSingleProduct(-1L))
//                .thenThrow(productNotFoundException);
//
//        Exception exception = assertThrows(
//                ProductNotFoundException.class,
//                () -> {
//                    productController.getSingleProduct(-1L);
//                }
//        );
//
//        assertEquals(productNotFoundException.getMessage(),exception.getMessage());
    }
}