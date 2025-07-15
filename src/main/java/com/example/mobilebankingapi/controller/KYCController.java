package com.example.mobilebankingapi.controller;

import com.example.mobilebankingapi.service.KycService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kyc")
@RequiredArgsConstructor
public class KYCController {

    private final KycService kycService;

    @PutMapping("/{customerId}/verify")
    public ResponseEntity<Void> verifyKyc(@PathVariable Long customerId) {
        kycService.verifyKycByCustomerId(customerId);
        return ResponseEntity.ok().build();
    }

}
