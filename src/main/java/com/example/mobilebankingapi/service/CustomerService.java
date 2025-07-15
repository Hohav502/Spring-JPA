package com.example.mobilebankingapi.service;

import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;
import com.example.mobilebankingapi.dto.UpdateCustomerRequest;

import java.util.List;

public interface CustomerService {

    void disableByPhoneNumber(String phoneNumber);

    void deleteByPhoneNumber(String phoneNumber);

    CustomerRespone updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest);

    CustomerRespone findByPhoneNumber(String phoneNumber);

    CustomerRespone createNew(CreateCustomerRequest createCustomerRequest);

    List<CustomerRespone> findAll();
}
