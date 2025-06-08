package com.example.ProductService.controllerAdvice;

import com.example.ProductService.DTOs.ExceptionDTO;
import com.example.ProductService.DTOs.ProductNotFoundExceptionDTO;
import com.example.ProductService.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductServiceExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(){

        ExceptionDTO exceptionDto = new ExceptionDTO();
        exceptionDto.setMessage("Something went wrong!");
        exceptionDto.setResolutionDetails("You need to pay more money to get it resolved from us. Thanks!");

        return new ResponseEntity<>(exceptionDto,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDTO exceptionDto = new ProductNotFoundExceptionDTO();
        //TODO
        // exceptionDto.setProductId(????);

//        e.printStackTrace();
//        exceptionDto.setProductId(e.getProductId());
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setResolution("Please try again with a valid product id");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}
