package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Product;
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

    @GetMapping
    public List<Product> getFeaturedProducts(){
        return productDB.findByPopularity(5);
    }
}