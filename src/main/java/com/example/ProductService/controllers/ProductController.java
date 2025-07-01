package com.example.ProductService.controllers;

import com.example.ProductService.DTOs.ExceptionDTO;
import com.example.ProductService.commons.AuthCommons;
import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Product;
import com.example.ProductService.services.ProductService;
import com.example.UserAuthService.dtos.UserDto;
import com.example.UserAuthService.exceptions.InvalidTokenException;
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
    private AuthCommons authCommons;

    public ProductController(
//            @Qualifier("selfProductService")
            ProductService productService,
            AuthCommons authCommons
    ){
        this.productService = productService;
        this.authCommons = authCommons;
    }

    @GetMapping("/{id}/{token}")
    public
//    ResponseEntity<Product>
    Product
    getSingleProduct(@PathVariable("id") Long productId,
                     @PathVariable String token) throws ProductNotFoundException {

//        ResponseEntity<Product> responseEntity  =
//                new ResponseEntity<>(
//                        productService.getSingleProduct(productId),
//                        HttpStatus.OK
//                );

//        Product product = null;
//
//        try {
//            product = productService.getSingleProduct(productId);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (RuntimeException e){
//            e.printStackTrace();
//            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

//        return responseEntity;

        UserDto userDto = authCommons.validateToken(token);

        if (userDto == null) {
            throw new InvalidTokenException("Invalid token provided");
        }

        return productService.getSingleProduct(productId);
    }

    @GetMapping("/")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) throws CategoryNotFoundException {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage("Handling exception with the controller.");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
