package main.java.com.sg.mthree.webstore.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageid;
    @Column(insertable = false, updatable = false)
    private int productid;
    @Column
    private String image_path;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
}
