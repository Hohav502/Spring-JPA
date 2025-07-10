package com.example.mobilebankingapi.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorRespone <T>(
        String message,
        Integer status,
        LocalDateTime timestamp,
        T details
) {
}







