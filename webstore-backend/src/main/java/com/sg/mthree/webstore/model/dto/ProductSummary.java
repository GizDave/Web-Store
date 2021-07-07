package main.java.com.sg.mthree.webstore.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ProductSummary {
    private int productid;
    private String name;
    private boolean instock;
    private float price;
    private String description;
    private List<Image> images;
}