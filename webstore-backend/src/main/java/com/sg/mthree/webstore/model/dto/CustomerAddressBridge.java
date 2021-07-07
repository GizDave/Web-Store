package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "Customer_Address_Bridge")
public class CustomerAddressBridge implements Serializable {
    @Id
    @Column(name = "customerid")
    private int customerid;
    @Id
    @Column(name = "addressid")
    private int addressid;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="customerid", referencedColumnName="customerid")
    @JoinColumn(name = "customerid")
    private Customer customer;
    @ManyToOne
    @PrimaryKeyJoinColumn(name="addressid", referencedColumnName="addressid")
    private Address address;
}
