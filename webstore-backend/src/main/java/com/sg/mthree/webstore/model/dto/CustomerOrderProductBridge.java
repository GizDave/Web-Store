package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "Customer_Order_Product_Bridge")
public class CustomerOrderProductBridge implements Serializable {
    @Id
    @Column
    private int orderid;
    @Id
    @Column
    private int productid;
    @Column
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "orderid")
    private CustomerOrder customerOrder;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
}
