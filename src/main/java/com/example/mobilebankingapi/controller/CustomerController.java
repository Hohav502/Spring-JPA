package com.example.mobilebankingapi.controller;


import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;
import com.example.mobilebankingapi.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor

public class CustomerController {

    @GetMapping
    public List<CustomerRespone> findAll() {
        return customerService.findAll();
    }

    private final CustomerService customerService;

    @PostMapping
    public CustomerRespone createNew(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {

        return customerService.createNew(createCustomerRequest);
    }
}
