package com.example.mobilebankingapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;


@RestControllerAdvice

public class ServiceException {

    @ExceptionHandler(ResponseStatusException.class)

    public ResponseEntity<?> handleServiceException(ResponseStatusException e) {

        ErrorRespone<String> error  = ErrorRespone.<String>builder()
                .message( "Bussiness login error")
                .status(e.getStatusCode().value())
                .timestamp(LocalDateTime.now())
                .details(e.getReason())
                .build();

        return ResponseEntity.status(e.getStatusCode()).body(error);
    }
}



