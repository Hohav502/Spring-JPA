package com.example.mobilebankingapi.repository;

import com.example.mobilebankingapi.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {


}
