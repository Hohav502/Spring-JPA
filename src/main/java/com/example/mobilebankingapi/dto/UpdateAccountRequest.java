package com.example.mobilebankingapi.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record UpdateAccountRequest(

        String actName,

        BigDecimal balance
) { }