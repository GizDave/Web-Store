package main.java.com.sg.mthree.webstore.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity(name = "Products")
public class Product implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productid;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "categoryid", insertable = false, updatable = false)
    private int categoryid;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "price")
    private float price;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    @Override
    public int compareTo(Object o) {
        if(o instanceof Product){
            Product temp = (Product) o;
            return this.name.compareTo(temp.getName());
        }
        else {
            return -1;
        }
    }
}
