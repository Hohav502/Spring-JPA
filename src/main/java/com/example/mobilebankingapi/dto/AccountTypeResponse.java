package com.example.mobilebankingapi.dto;

import lombok.Builder;

@Builder
public record AccountTypeResponse(
        String typeName
) {
}
