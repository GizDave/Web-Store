package com.sg.mthree.webstore.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private int categoryid;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
    @OneToMany(mappedBy = "product")
    private Set<CustomerOrderProductBridge> customerOrderProductBridgeSet;
    @OneToMany(mappedBy = "product")
    private Set<ProductOptionBridge> productOptionBridgeSet;
}
