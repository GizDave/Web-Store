package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;
    @Column
    private int paymentmethodid;
    @Column
    private int customerid;
    @Column
    private LocalDateTime date_ordered;
    @Column
    private float total_price;
    @ManyToOne
    @JoinColumn(name = "paymentmethodid")
    private CustomerPayment customerPayment;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
}
