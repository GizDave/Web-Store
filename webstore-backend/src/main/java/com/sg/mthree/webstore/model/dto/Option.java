package com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int optionid;
    @Column
    private String name;
    @Column
    private BigDecimal price;
    @Column
    private int stockid;
    @ManyToOne
    @JoinColumn(name = "stockid")
    private Stock stock;
}
