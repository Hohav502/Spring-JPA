package com.example.mobilebankingapi.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCustomerRequest(

        String fullName,
        String gender,
        String remark
) {
}
