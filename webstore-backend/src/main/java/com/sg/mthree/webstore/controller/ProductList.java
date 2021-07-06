package com.sg.mthree.webstore.controller;

import com.sg.mthree.webstore.model.dao.CategoryRepository;
import com.sg.mthree.webstore.model.dao.ProductRepository;
import com.sg.mthree.webstore.model.dto.Category;
import com.sg.mthree.webstore.model.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/productlist")
public class ProductList {
    @Autowired
    private ProductRepository productDB;

    @Autowired
    private CategoryRepository categoryDB;

    private int pageNumber;
    private int itemCount;
    private int totalCount;
    private Category category;
    private String displayOrder;

    private List<Category> categoryOption;
    private List<Integer> itemCountOption;
    private List<String> displayOrderOption;

    public ProductList(){
        Integer[] icOption = {10, 15, 25, 30};
        itemCountOption = Arrays.asList(icOption);

        String[] doOption = {"Ascending", "Descending", "None"};
        displayOrderOption = Arrays.asList(doOption);

        refreshCategoryOption();

        pageNumber = 1;
        itemCount = itemCountOption.get(0);
        category = categoryOption.get(0);
        displayOrder = displayOrderOption.get(2);
    }

    @GetMapping("/get/pageNumber")
    public int getPageNumber(){return pageNumber+1;}
    @GetMapping("/get/itemCount")
    public int getItemCount(){return itemCount;}
    @GetMapping("/get/displayOrder")
    public String getDisplayOrder(){return displayOrder;}
    @GetMapping("/get/availableItemCounts")
    public int[] getItemCountOption(){return itemCountOption;}
    @GetMapping("/get/availableDisplayOrders")
    public String[] getDisplayOrderOption(){return displayOrderOption;}
    @GetMapping("/get/categories")
    public List<String> getCategories(){return categoryDB.findAllName();}

    @PutMapping("/set")
    public ResponseEntity<String> setPageNumber(@RequestParam("pageNumber") int newPageNumber){
        if(newPageNumber > 0 && newPageNumber * itemCount <= totalCount) {
            this.pageNumber = pageNumber;
        }
        else {

        }
    }
    @PutMapping("/set")
    public ResponseEntity<String> setItemCount(@RequestParam("itemCount") int itemCountIdex){
        if() {

        }
        else {

        }
    }
    @PutMapping("/set")
    public ResponseEntity<String> setDisplayOrder(@RequestParam("displayOrder") int displayOrderIndex){
        if() {

        }
        else {

        }
    }
    @PutMapping("/set")
    public ResponseEntity<String> setCategory(@RequestParam("category") int categoryIndex){
        if() {

        }
        else {

        }
    }

    @GetMapping("/nextpage")
    public ResponseEntity<List<Product>> nextPage(){
        if(itemCount * (pageNumber + 1) > totalCount){

        }
        else {

        }
    }

    @GetMapping("/previouspage")
    public ResponseEntity<List<Product>> prevPage(){
        if(pageNumber - 1 < 1){

        }
        else {

        }
    }

    @GetMapping("/search/{query}")
    public List<Product> search(@RequestParam String query){
        pageNumber = 0;
        return productDB.findByName(query, pageNumber, itemCount, displayOrder);
    }

    private void refreshCategoryOption(){
        categoryOption = categoryDB.findAll();
    }
}