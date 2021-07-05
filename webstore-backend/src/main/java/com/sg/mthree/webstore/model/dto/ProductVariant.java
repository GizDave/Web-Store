package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int variantid;
    @Column
    private String name;
    @Column
    private int productid;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
}
