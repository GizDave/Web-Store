package com.sg.mthree.webstore.controller;

import com.sg.mthree.webstore.model.dao.ImageRepository;
import com.sg.mthree.webstore.model.dao.ProductRepository;
import com.sg.mthree.webstore.model.dto.Product;
import com.sg.mthree.webstore.model.dto.ProductSummary;
import com.sg.mthree.webstore.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/main")
@CrossOrigin(origins = "*")
public class MainPage {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private ImageRepository imageDB;

    @Autowired
    private Converter convert;

    @GetMapping("/featuredProducts")
    public List<ProductSummary> getFeaturedProducts(){
        int j;
        Random rand = new Random();
        List<Product> tempAgg = productDB.findAll();
        List<Product> tempP = new ArrayList<>();
        List<ProductSummary> buffer = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            j = rand.nextInt(tempAgg.size());
            tempP.add(tempAgg.remove(j));
        }

        return convert.productToThumbnail(tempP, buffer);
    }
}