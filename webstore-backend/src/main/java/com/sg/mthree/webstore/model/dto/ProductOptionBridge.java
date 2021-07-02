package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ProductOptionBridge {
    @Id
    @Column
    private int productid;
    @Id
    @Column
    private int optionid;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "optionid")
    private Option option;
}
