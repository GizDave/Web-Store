package com.sg.mthree.webstore.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class CustomerPaymentSummary {
    private int customerid;
    private String first_name;
    private String last_name;
    private String phone;
    private Address address;
    private List<CustomerPayment> payment;
}
