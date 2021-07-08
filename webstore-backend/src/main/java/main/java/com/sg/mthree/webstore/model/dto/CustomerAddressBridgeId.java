package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class CustomerAddressBridgeId implements Serializable {
    private int customerid;
    private int addressid;

    public CustomerAddressBridgeId(int customerid, int addressid) {
        this.customerid = customerid;
        this.addressid = addressid;
    }
}
