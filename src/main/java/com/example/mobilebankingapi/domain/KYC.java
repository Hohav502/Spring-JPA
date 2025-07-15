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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //UUID

    @Column(nullable = false, unique = true)
    private String nationalCardId;

    @Column(nullable = false)
    private Boolean isVerified = false;

    @Column(nullable = false)
    private Boolean isDeleted = false;

    @OneToOne
    @MapsId
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;


}
