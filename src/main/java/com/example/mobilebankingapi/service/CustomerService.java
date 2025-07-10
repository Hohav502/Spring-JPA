package com.example.mobilebankingapi.service;

import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;

import java.util.List;

public interface CustomerService {

    CustomerRespone findByPhoneNumber(String phoneNumber);

    CustomerRespone createNew(CreateCustomerRequest createCustomerRequest);

    List<CustomerRespone> findAll();
}
