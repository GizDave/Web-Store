package com.sg.webstoretesting.controller;

import com.sg.webstoretesting.dao.ProductRepository;
import com.sg.webstoretesting.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ProductList {

    private final ProductRepository products;

    public Product saveProduct(Product product) {
        return products.save(product);
    }


}
