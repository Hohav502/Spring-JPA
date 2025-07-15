package com.example.mobilebankingapi.service.impl;

import com.example.mobilebankingapi.domain.KYC;
import com.example.mobilebankingapi.repository.KycRepository;
import com.example.mobilebankingapi.service.KycService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class KycServiceImpl implements KycService {

    private final KycRepository kycRepository;

    @Transactional
    @Override
    public void verifyKycByCustomerId(Long customerId) {
        KYC kyc = kycRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "KYC not found for customer ID: " + customerId));

        kyc.setIsVerified(true);
        kycRepository.save(kyc);
    }
}
