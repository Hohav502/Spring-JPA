package com.example.mobilebankingapi.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record AccountRespond(
        String actName, // optional field
        String actNo,
        BigDecimal balance,
        BigDecimal overLimit, // optional field
        String accountType
) {}
