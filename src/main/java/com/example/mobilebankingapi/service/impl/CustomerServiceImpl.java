package com.example.mobilebankingapi.service.impl;

import com.example.mobilebankingapi.domain.Customer;
import com.example.mobilebankingapi.dto.CreateCustomerRequest;
import com.example.mobilebankingapi.dto.CustomerRespone;
import com.example.mobilebankingapi.dto.UpdateCustomerRequest;
import com.example.mobilebankingapi.mapper.CustomerMapper;
import com.example.mobilebankingapi.repository.CustomerRepository;
import com.example.mobilebankingapi.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {


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

       customer =  customerRepository.save(customer);

        return customerMapper.fromCustomer(customer);
    }

    @Override
    public CustomerRespone findByPhoneNumber(String phoneNumber) {

        return customerRepository
                .findByPhoneNumber(phoneNumber)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Customers phone number not found"));
    }


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    @Override
    public CustomerRespone createNew(CreateCustomerRequest createCustomerRequest){

        //validate email
        if(customerRepository.existsByEmail(createCustomerRequest.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT ,"Phone number already exist!");
        }

          Customer customer = customerMapper.toCustomer(createCustomerRequest);



//        customer.setFullName(createCustomerRequest.fullName());
//        customer.setGender(createCustomerRequest.gender());
//        customer.setEmail(createCustomerRequest.email());
//        customer.setPhoneNumber(createCustomerRequest.phoneNumber());
//        customer.setRemark(createCustomerRequest.remark());
        customer.setIsDeleted(false);
        customer.setAccounts(new ArrayList<>());



        log.info("Customer before save: {}", customer.getId());
        customer = customerRepository.save(customer);

//        return CustomerRespone.builder()
//                .fullName(customer.getFullName())
//                .gender(customer.getGender())
//                .email(customer.getEmail())
//                .build();

        return customerMapper.fromCustomer(customer);
    }


    @Override
    public List<CustomerRespone> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers
                .stream()
                .map(customerMapper::fromCustomer)
                .toList();
    }
}
