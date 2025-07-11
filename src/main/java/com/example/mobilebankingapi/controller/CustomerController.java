package com.example.mobilebankingapi.controller;


import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;
import com.example.mobilebankingapi.dto.UpdateCustomerRequest;
import com.example.mobilebankingapi.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/{phoneNumber}")
    public CustomerRespone updateByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber, @RequestBody @Valid UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateByPhoneNumber(phoneNumber,updateCustomerRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{phoneNumber}")
    public void  deleteByPhoneNumber(@PathVariable String phoneNumber) {
        customerService.deleteByPhoneNumber(phoneNumber);

    }

    @GetMapping("/{phoneNumber}")
    public CustomerRespone findByPhoneNumber(@PathVariable String phoneNumber) {
        return customerService.findByPhoneNumber(phoneNumber);
    }


    @PostMapping
    public CustomerRespone createNew(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {

        return customerService.createNew(createCustomerRequest);
    }
}
