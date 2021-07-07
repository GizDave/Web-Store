package main.java.com.sg.mthree.webstore.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productid;
    @Column
    private String name;
    @Column
    private String description;
    @Column(insertable = false, updatable = false)
    private int categoryid;
    @Column
    private String thumbnail;
    @Column
    private float price;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
}
