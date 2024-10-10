package com.pis.productinventorysystem.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyyMMdd hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();
    private HttpStatus httpStatus;

    public ErrorResponse(String message,HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
