package com.pis.productinventorysystem.controller.handler;

import com.pis.productinventorysystem.exception.ProductNotFoundException;
import com.pis.productinventorysystem.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorResponse> productNotFound(Exception e){
        return buildResponseEntity(new ErrorResponse("Product not found", HttpStatus.NOT_FOUND));
    }


    private ResponseEntity<ErrorResponse> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<ErrorResponse>(errorResponse,errorResponse.getHttpStatus());
    }
}
