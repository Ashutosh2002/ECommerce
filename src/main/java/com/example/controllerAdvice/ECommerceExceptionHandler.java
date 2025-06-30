package com.example.controllerAdvice;

import com.example.ProductService.DTOs.ExceptionDTO;
import com.example.ProductService.DTOs.ProductNotFoundExceptionDTO;
import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.UserAuthService.exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ECommerceExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(){

        ExceptionDTO exceptionDto = new ExceptionDTO();
        exceptionDto.setMessage("Something went wrong!");
        exceptionDto.setResolutionDetails("We are trying to resolve this as soon as possible.");

        return new ResponseEntity<>(exceptionDto,HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> handleProductNotFoundException(ProductNotFoundException e) {
        ProductNotFoundExceptionDTO exceptionDto = new ProductNotFoundExceptionDTO();
        //TODO
        // exceptionDto.setProductId(????);

//        e.printStackTrace();
        exceptionDto.setProductId(e.getProductId());
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setResolution("Please try again with a valid product id");

        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleCategoryNotFoundException(CategoryNotFoundException exception){
        ExceptionDTO exceptionDto = new ExceptionDTO();
        exceptionDto.setMessage("Category of product not found");
        exceptionDto.setResolutionDetails("Please mention the category of the product.");

        return new ResponseEntity<>(exceptionDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionDTO> handleUserAlreadyExxistException(UserAlreadyExistException e) {
        ExceptionDTO exceptionDto = new ExceptionDTO();
        //TODO
        // exceptionDto.setProductId(????);

//        e.printStackTrace();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setResolutionDetails("Please try to login with this user");

        return new ResponseEntity<>(exceptionDto, HttpStatus.UNAUTHORIZED);
    }

}
