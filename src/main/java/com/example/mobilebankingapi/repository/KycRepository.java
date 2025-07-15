package com.example.mobilebankingapi.repository;

import com.example.mobilebankingapi.domain.KYC;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Jenh exam next month
public interface KycRepository extends CrudRepository<KYC,Integer>{

    // Method to find KYC by the customer's ID (linked entity)
    Optional<KYC> findByCustomerId(Long customerId);

}
