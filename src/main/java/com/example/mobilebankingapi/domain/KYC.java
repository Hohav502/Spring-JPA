package com.example.mobilebankingapi.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Know your customer
@Getter
@Setter
@NoArgsConstructor
@Entity
public class KYC {
    @Id

    private Integer id; //UUID
    private String nationalCardId;
    private Boolean isVerified;
    private Boolean isDeleted;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cust_id")
    private Customer customer;
}
