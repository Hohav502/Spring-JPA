package com.example.mobilebankingapi.service.impl;

import com.example.mobilebankingapi.domain.AccountType;
import com.example.mobilebankingapi.dto.AccountTypeResponse;
import com.example.mobilebankingapi.dto.CreateAccountTypeRequest;
import com.example.mobilebankingapi.mapper.AccountMapper;
import com.example.mobilebankingapi.repository.AccountTypeRepository;
import com.example.mobilebankingapi.service.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {
    private final AccountTypeRepository accountTypeRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountTypeResponse createAccountType(CreateAccountTypeRequest request) {
        String normalizedName = request.typeName().toUpperCase(Locale.ROOT);

        if(accountTypeRepository.existsAccountTypeByTypeName(normalizedName)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account type already exists");
        }

        AccountType accountType = new AccountType();
        accountType.setTypeName(normalizedName);

        return accountMapper.toAccountTypeResponse(accountTypeRepository.save(accountType));
    }
}
