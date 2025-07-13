package com.example.mobilebankingapi.mapper;

import com.example.mobilebankingapi.domain.Account;
import com.example.mobilebankingapi.domain.AccountType;
import com.example.mobilebankingapi.dto.AccountRespond;
import com.example.mobilebankingapi.dto.AccountTypeResponse;
import com.example.mobilebankingapi.dto.CreateAccountRequest;
import com.example.mobilebankingapi.dto.UpdateAccountRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    // Convert CreateAccountRequest → Account
    @Mapping(target = "actNo", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "accountType", ignore = true) // Set manually later
    Account customerRequestToAccount(CreateAccountRequest createAccountRequest);

    // Convert Account → AccountRespond (Map typeName to accountType)
    @Mapping(target = "accountType", source = "account.accountType.typeName")
    AccountRespond accountToAccountResponse(Account account);

    // Convert AccountType → DTO
    AccountTypeResponse toAccountTypeResponse(AccountType accountType);

    // Partial update method for PATCH/PUT
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toAccountPartially(UpdateAccountRequest updateAccountRequest, @MappingTarget Account account);
}
