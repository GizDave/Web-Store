package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerOrderProductBridgeId implements Serializable {
    private int orderid;
    private int productid;

    public CustomerOrderProductBridgeId(int orderid, int productid) {
        this.orderid = orderid;
        this.productid = productid;
    }
}
