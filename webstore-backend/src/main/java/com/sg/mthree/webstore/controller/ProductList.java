package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CategoryRepository;
import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Category;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.ProductSummary;
import main.java.com.sg.mthree.webstore.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/productlist")
public class ProductList {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private CategoryRepository categoryDB;

    @Autowired
    private ImageRepository imageDB;

    private int pageNumber;
    private int itemCount;
    private int totalCount;
    private int maxPageNumber;
    private String displayOrder;
    private Category category;

    private List<ProductSummary> buffer;
    private List<Category> categoryOption;
    private List<Integer> itemCountOption;
    private List<String> displayOrderOption;

    @Autowired
    private Converter convert;

    @PostConstruct
    private void setup(){
        Integer[] icOption = {2, 3, 4};
        itemCountOption = Arrays.asList(icOption);

        String[] doOption = {"Ascending", "Descending", "None"};
        displayOrderOption = Arrays.asList(doOption);

        categoryOption = categoryDB.findAll();

        pageNumber = 0;
        itemCount = itemCountOption.get(0);
        category = categoryOption.get(0);
        displayOrder = displayOrderOption.get(2);

        buffer = new ArrayList<>();
        refreshBuffer(null);
    }

    @GetMapping("/pageNumber/get")
    public int getPageNumber(){return pageNumber+1;}
    @GetMapping("/maxPageNumber/get")
    public int getMaxPageNumber(){return maxPageNumber;}
    @GetMapping("/itemCount/get")
    public int getItemCount(){return itemCount;}
    @GetMapping("/category/get")
    public Category getCategory(){return category;}
    @GetMapping("/displayOrder/get")
    public String getDisplayOrder(){return displayOrder;}
    @GetMapping("/availableItemCounts/get")
    public List<Integer> getItemCountOption(){return itemCountOption;}
    @GetMapping("/availableDisplayOrders/get")
    public List<String> getDisplayOrderOption(){return displayOrderOption;}
    @GetMapping("/availableCategoryOption/get")
    public List<Category> getCategories(){return categoryOption;}
    @GetMapping("/products/get/all")
    public List<ProductSummary> getAllProducts(){
        List<Product> tempAgg = productDB.findAll();
        List<ProductSummary> buffer = new ArrayList<>();
        return convert.productToThumbnail(tempAgg, buffer);
    }

    @PutMapping("/pageNumber/set")
    public ResponseEntity<List<ProductSummary>> setPageNumber(@RequestParam int newPageNumber) {
        if(newPageNumber > 0 && newPageNumber <= maxPageNumber) {
            this.pageNumber = newPageNumber-1;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/itemCount/set")
    public ResponseEntity<List<ProductSummary>> setItemCount(@RequestParam int itemCountIndex) {
        if(itemCountIndex >= 0 && itemCountIndex < itemCountOption.size()) {
            this.pageNumber = 0;
            this.itemCount = itemCountOption.get(itemCountIndex);
            this.maxPageNumber = (int) Math.ceil(totalCount/itemCount) + 1;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/displayOrder/set")
    public ResponseEntity<List<ProductSummary>> setDisplayOrder(@RequestParam int displayOrderIndex){
        if(displayOrderIndex >= 0 && displayOrderIndex < displayOrderOption.size()) {
            if(this.displayOrder != displayOrderOption.get(displayOrderIndex) &&
                    (this.displayOrder.equals("Descending") || displayOrderOption.get(displayOrderIndex).equals("Descending"))) {
                this.pageNumber = 0;
                Collections.reverse(buffer);
            }
            this.displayOrder = displayOrderOption.get(displayOrderIndex);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/categories/set")
    public ResponseEntity<List<ProductSummary>> setCategory(@RequestParam int categoryIndex) {
        if(categoryIndex >= 0 && categoryIndex < categoryOption.size()) {
            this.category = categoryOption.get(categoryIndex);
            refreshBuffer(null);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/nextPage")
    public ResponseEntity<List<ProductSummary>> nextPage() {
        if(pageNumber + 1 < maxPageNumber) {
            pageNumber += 1;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/previousPage")
    public ResponseEntity<List<ProductSummary>> prevPage() {
        if(pageNumber - 1 < 0){
            pageNumber -= 1;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductSummary>> search(@RequestParam String query) {
        pageNumber = 0;
        refreshBuffer(query);
        return ResponseEntity.status(HttpStatus.OK)
                .body(refreshPage());
    }

    private void refreshBuffer(String query){
        buffer.clear();
        List<Product> tempP = null;

        if(query != null) {
            if(query.length() > 0) {
                tempP = productDB.findByName(query, category.getCategoryid());
            }
            else {
                return;
            }
        }
        else {
            tempP = productDB.findByCategoryId(category.getCategoryid());
        }

        Collections.sort(tempP);
        if(displayOrder == "Descending"){
            Collections.reverse(tempP);
        }

        convert.productToThumbnail(tempP, buffer);
        totalCount = buffer.size();
        maxPageNumber = (int) Math.ceil(totalCount/itemCount) + 1;
    }

    private List<ProductSummary> refreshPage() {
        return buffer.subList(pageNumber*itemCount, Math.min(buffer.size(), (pageNumber+1)*itemCount));
    }
}