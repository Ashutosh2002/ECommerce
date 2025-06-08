package com.example.ProductService.controllers;

import com.example.ProductService.DTOs.ExceptionDTO;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException {

        ResponseEntity<Product> responseEntity  =
                new ResponseEntity<>(
                        productService.getSingleProduct(productId),
                        HttpStatus.OK
                );

//        Product product = null;
//
//        try {
//            product = productService.getSingleProduct(productId);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (RuntimeException e){
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

        return responseEntity;
//        return productService.getSingleProduct(productId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return new Product();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long productId){
        return null;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Handling exception with the controller.");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
