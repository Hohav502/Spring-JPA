package com.example.mobilebankingapi.service;

import com.example.mobilebankingapi.dto.AccountTypeResponse;
import com.example.mobilebankingapi.dto.CreateAccountTypeRequest;

public interface AccountTypeService {

    AccountTypeResponse createAccountType(CreateAccountTypeRequest request);


}
