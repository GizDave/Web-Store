package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressid;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String state;
    @Column
    private String zipcode;
    @Column
    private String country;
    @OneToMany(mappedBy = "address")
    private Set<CustomerAddressBridge> customerAddressBridgeSet;
}
