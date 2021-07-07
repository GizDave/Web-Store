package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "Customer_Orders")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressid")
    private int orderid;
    @Column(name = "paymentmethodid", insertable = false, updatable = false)
    private int paymentmethodid;
    @Column(name = "customerid", insertable = false, updatable = false)
    private int customerid;
    @Column(name = "date_ordered")
    private LocalDateTime date_ordered;
    @Column(name = "total_price")
    private float total_price;
    @ManyToOne
    @JoinColumn(name = "paymentmethodid")
    private CustomerPayment customerPayment;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
}
