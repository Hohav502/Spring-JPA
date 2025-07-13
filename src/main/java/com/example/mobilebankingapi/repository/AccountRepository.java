package com.example.mobilebankingapi.repository;

import com.example.mobilebankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findAccountByActNo(String actNo);

    Optional<List<Account>> findAccountByCustomer_PhoneNumber(String phoneNumber);

    boolean existsByCustomer_PhoneNumberAndAccountType_TypeName(String phone, String typeName);

}
