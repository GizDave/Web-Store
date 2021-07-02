package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CustomerPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentmethodid;
    @Column
    private int customerid;
    @Column
    private String card_number;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
}
