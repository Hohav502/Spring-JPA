package com.example.mobilebankingapi;

import com.example.mobilebankingapi.domain.Customer;
import com.example.mobilebankingapi.domain.KYC;
import com.example.mobilebankingapi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MobileBankingApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MobileBankingApiApplication.class, args);
    }

    private final CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
//        Customer customer = new Customer();
//        KYC kyc = new KYC();
//        kyc.setNationalCardId("999990000");
//        kyc.setIsVerified(false);
//        kyc.setIsDeleted(false);
//        kyc.setCustomer(customer);
//
//
//        customer.setFullName("HO HAV");
//        customer.setGender("M");
//        customer.setEmail("Hav@gmail.com");
//        customer.setPhoneNumber("1234567890");
//        customer.setKyc(kyc);
//        customer.setRemark("Student");
//        customer.setIsDeleted(false);
//
//        customerRepository.save(customer);

    }
}
