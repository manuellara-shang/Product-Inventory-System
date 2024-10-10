package com.pis.productinventorysystem.exception;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "product not found")
@RequiredArgsConstructor
public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message){
        super(message);
    }
}
