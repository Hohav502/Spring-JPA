package com.example.mobilebankingapi.repository;


import com.example.mobilebankingapi.domain.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
    Optional<AccountType> findAccountTypeByTypeName(String typeName);

    boolean existsAccountTypeByTypeName(String typeName);
}
