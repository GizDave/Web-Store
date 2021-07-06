package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Image;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.Thumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/main")
public class MainPage {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private ImageRepository imageDB;

    @GetMapping("/featuredProducts")
    public List<Thumbnail> getFeaturedProducts(){
        List<Product> tempP = productDB.findByPopularity(5);
        List<Thumbnail> buffer = new ArrayList<>();
        List<Image> tempI = null;

        for(Product p: tempP) {
            Thumbnail tn = new Thumbnail();
            tn.setProductid(p.getProductid());
            tn.setName(p.getName());
            tn.setDescription(p.getDescription());

            tempI = imageDB.findByProductId(p.getProductid());
            if(tempI.size() > 0){
                tn.setImage_path(tempI.get(0).getImage_path()); // default to first image of the product
            }

            buffer.add(tn);
        }

        return buffer;
    }
}