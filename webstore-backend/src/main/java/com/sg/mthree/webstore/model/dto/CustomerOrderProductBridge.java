package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "Customer_Order_Product_Bridge")
@IdClass(CustomerOrderProductBridgeId.class)
public class CustomerOrderProductBridge implements Serializable {
    @Id
    @Column(name = "orderid", insertable = false, updatable = false)
    private int orderid;
    @Id
    @Column(name = "productid", insertable = false, updatable = false)
    private int productid;
    @Column(name = "quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "orderid")
    private CustomerOrder customerOrder;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
}
