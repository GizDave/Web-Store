package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CustomerOrderProductBridge {
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
