package com.example.mobilebankingapi.service.impl;

import com.example.mobilebankingapi.domain.Customer;
import com.example.mobilebankingapi.domain.KYC;
import com.example.mobilebankingapi.domain.Segment;
import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;
import com.example.mobilebankingapi.dto.UpdateCustomerRequest;
import com.example.mobilebankingapi.mapper.CustomerMapper;
import com.example.mobilebankingapi.repository.CustomerRepository;
import com.example.mobilebankingapi.repository.KycRepository;
import com.example.mobilebankingapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final KycRepository kycRepository;

    @Override
    public void deleteByPhoneNumber(String phoneNumber) {
        Customer customer = customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer phone number not found"));

        customerRepository.delete(customer);
    }

    @Override
    public CustomerRespone updateByPhoneNumber(String phoneNumber, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = customerRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer phone number not found"));

        customerMapper.toCustomerPartially(updateCustomerRequest, customer);

        customer = customerRepository.save(customer);

        return customerMapper.fromCustomer(customer);
    }

    @Override
    public CustomerRespone findByPhoneNumber(String phoneNumber) {
        return customerRepository
                .findByPhoneNumberAndIsDeletedFalse(phoneNumber)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customers phone number not found"));
    }

    @Transactional
    @Override
    public void disableByPhoneNumber(String phoneNumber) {
        if (!customerRepository.existsByPhoneNumber(phoneNumber)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer phone number not found");
        }
        customerRepository.disableByPhoneNumber(phoneNumber);
    }

    @Override
    public CustomerRespone createNew(CreateCustomerRequest createCustomerRequest) {
        // Validate email uniqueness
        if (customerRepository.existsByEmail(createCustomerRequest.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists!");
        }

        // Validate phone number uniqueness
        if (customerRepository.existsByPhoneNumber(createCustomerRequest.phoneNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Phone number already exists!");
        }

        // Map DTO to entity
        Customer customer = customerMapper.toCustomer(createCustomerRequest);
        customer.setIsDeleted(false);
        customer.setAccounts(new ArrayList<>());

        // Validate and set segment enum
        try {
            customer.setSegment(Segment.valueOf(createCustomerRequest.segment().toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Segment must be GOLD, SILVER, or REGULAR");
        }

        // Save customer
        customer = customerRepository.save(customer);

        // Auto-create KYC record with verified = false
        KYC kyc = new KYC();
        kyc.setCustomer(customer);
        kyc.setNationalCardId(customer.getNationalCardId());
        kyc.setIsVerified(false);
        kyc.setIsDeleted(false);
        kycRepository.save(kyc);

        return customerMapper.fromCustomer(customer);
    }

    @Override
    public List<CustomerRespone> findAll() {
        List<Customer> customers = customerRepository.findAllByIsDeletedFalse();
        return customers
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }
}
