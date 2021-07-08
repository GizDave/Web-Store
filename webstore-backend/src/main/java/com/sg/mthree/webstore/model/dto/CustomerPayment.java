package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Customer_Payments")
public class CustomerPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentmethodid")
    private int paymentmethodid;
    @Column(name = "customerid", insertable = false, updatable = false)
    private int customerid;
    @Column(name = "card_number")
    private String card_number;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
}
