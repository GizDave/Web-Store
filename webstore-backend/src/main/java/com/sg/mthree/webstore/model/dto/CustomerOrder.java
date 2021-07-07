package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Customer_Orders")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderid;
    @Column(insertable = false, updatable = false)
    private int paymentmethodid;
    @Column(insertable = false, updatable = false)
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
    @OneToMany(mappedBy = "customerOrder")
    private Set<CustomerOrderProductBridge> customerOrderProductBridgeSet;
}
