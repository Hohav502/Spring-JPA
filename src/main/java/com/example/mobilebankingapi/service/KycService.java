package com.example.mobilebankingapi.service;

public interface KycService {

    /**
     * Verify KYC by customer ID.
     *
     * @param customerId Customer's ID
     */
    void verifyKycByCustomerId(Long customerId);
}
