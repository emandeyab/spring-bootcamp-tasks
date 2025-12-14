package com.springApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
    public ResponseEntity<ProductErrorResponce> handelProductNotFoundException(ProductNotFoundException e){
        ProductErrorResponce productErrorResponce = new ProductErrorResponce();
        productErrorResponce.setErrorCode(HttpStatus.NOT_FOUND.value());
        productErrorResponce.setErrorMessage(e.getMessage());
        productErrorResponce.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(productErrorResponce, HttpStatus.NOT_FOUND);
    }
}
