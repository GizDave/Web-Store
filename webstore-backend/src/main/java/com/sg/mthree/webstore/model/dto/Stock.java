package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stockid")
    private int stockid;
    @Column(name = "productid")
    private int productid;
    @Column(name = "instock")
    private boolean instock;
    @Column(name = "quantity")
    private int quantity;
}
