package com.example.mobilebankingapi.dto;


import lombok.Builder;

@Builder
public record CustomerRespone(
        String fullName,
        String gender,
        String email
) {
}
