package com.example.mobilebankingapi.service;

import com.example.mobilebankingapi.dto.AccountRespond;
import com.example.mobilebankingapi.dto.CreateAccountRequest;
import com.example.mobilebankingapi.dto.CustomerPhoneRequest;
import com.example.mobilebankingapi.dto.UpdateAccountRequest;

import java.util.List;

public interface AccountService {
    AccountRespond createAccount(CreateAccountRequest request);

    List<AccountRespond> findAll();

    AccountRespond findAccountByActNo(String actNo);

    void disableAccountByActNo(String actNo);

    void deleteAccountByActNo(String actNo);

    AccountRespond updateAccount(String actNo, UpdateAccountRequest request);

    List<AccountRespond> findAccountByCustomerPhone(CustomerPhoneRequest customerPhoneRequest);

}