package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.ProductSummary;
import main.java.com.sg.mthree.webstore.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainPage {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private ImageRepository imageDB;

    private Converter convert;

    public MainPage() {
        convert = new Converter();
    }

    @GetMapping("/featuredProducts")
    public List<ProductSummary> getFeaturedProducts(){
        List<Product> tempP = productDB.findByPopularity(5);
        return convert.productToThumbnail(tempP);
    }
}