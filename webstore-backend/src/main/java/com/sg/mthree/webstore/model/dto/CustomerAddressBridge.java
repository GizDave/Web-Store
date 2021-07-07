package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "Customer_Address_Bridge")
public class CustomerAddressBridge implements Serializable {
    @Id
    @Column
    private int customerid;
    @Id
    @Column
    private int addressid;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "addressid")
    private Address address;
}
