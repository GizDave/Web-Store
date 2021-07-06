package main.java.com.sg.mthree.webstore.service;

import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dao.StockRepository;
import main.java.com.sg.mthree.webstore.model.dto.Image;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.ProductSummary;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private ImageRepository imageDB;

    @Autowired
    private StockRepository stockDB;

    public List<ProductSummary> productToThumbnail(List<Product> products){
        List<ProductSummary> buffer = new ArrayList<>();
        List<Image> tempI = null;

        for(Product p: products) {
            ProductSummary tn = new ProductSummary();
            tn.setProductid(p.getProductid());
            tn.setName(p.getName());
            tn.setInstock(stockDB.existsById(p.getStockid()));
            tn.setPrice(p.getPrice());
            tn.setDescription(p.getDescription());
            tn.setImages(imageDB.findByProductId(p.getProductid()));

            buffer.add(tn);
        }

        return buffer;
    }
}
