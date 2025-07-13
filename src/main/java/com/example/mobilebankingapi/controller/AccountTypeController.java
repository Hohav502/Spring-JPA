package com.example.mobilebankingapi.controller;


import com.example.mobilebankingapi.dto.AccountTypeResponse;
import com.example.mobilebankingapi.dto.CreateAccountTypeRequest;
import com.example.mobilebankingapi.service.AccountTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account-types")
@RequiredArgsConstructor

public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountTypeResponse createAccountType(@Valid @RequestBody CreateAccountTypeRequest createAccountTypeRequest) {

        return accountTypeService.createAccountType(createAccountTypeRequest);
    }
}
