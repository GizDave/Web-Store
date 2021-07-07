package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Customer_Payments")
public class CustomerPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentmethodid;
    @Column(insertable = false, updatable = false)
    private int customerid;
    @Column
    private String card_number;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
}
