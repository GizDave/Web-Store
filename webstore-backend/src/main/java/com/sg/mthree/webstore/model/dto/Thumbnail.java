package main.java.com.sg.mthree.webstore.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Thumbnail {
    private int productid;
    private String name;
    private String description;
    private String image_path;
}
