package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CategoryRepository;
import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Category;
import main.java.com.sg.mthree.webstore.model.dto.Image;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.ProductSummary;
import main.java.com.sg.mthree.webstore.service.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

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
        Integer[] icOption = {10, 15, 20};
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
    public int getMaxPageNumber(){return (int) Math.ceil(totalCount/itemCount);}
    @GetMapping("/itemCount/get")
    public int getItemCount(){return itemCount;}
    @GetMapping("/displayOrder/get")
    public String getDisplayOrder(){return displayOrder;}
    @GetMapping("/availableItemCounts/get")
    public List<Integer> getItemCountOption(){return itemCountOption;}
    @GetMapping("/availableDisplayOrders/get")
    public List<String> getDisplayOrderOption(){return displayOrderOption;}
    @GetMapping("/categories/get")
    public List<Category> getCategories(){return categoryOption;}

    @PutMapping("/pageNumber/set/{newPageNumber}")
    public ResponseEntity<List<ProductSummary>> setPageNumber(@RequestParam int newPageNumber) {
        if(newPageNumber > 0 && newPageNumber * itemCount <= totalCount) {
            this.pageNumber = newPageNumber;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/itemCount/set/{itemCountIndex}")
    public ResponseEntity<List<ProductSummary>> setItemCount(@RequestParam int itemCountIndex) {
        if(itemCountIndex >= 0 && itemCountIndex < itemCountOption.size()) {
            this.itemCount = itemCountOption.get(itemCountIndex);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/displayOrder/set/{displayOrderIndex}")
    public ResponseEntity<List<ProductSummary>> setDisplayOrder(@RequestParam int displayOrderIndex){
        if(displayOrderIndex >= 0 && displayOrderIndex < displayOrderOption.size()) {
            this.displayOrder = displayOrderOption.get(displayOrderIndex);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/categories/set/{categoryIndex}")
    public ResponseEntity<List<ProductSummary>> setCategory(@RequestParam String categoryName) {
        Category temp = categoryDB.getCategoryByName(categoryName).get(0);
        if(temp != null) {
            this.category = temp;
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
        if(itemCount * (pageNumber + 1) > totalCount) {
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
        if(pageNumber - 1 < 1){
            pageNumber -= 1;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/search/{query}")
    public ResponseEntity<List<ProductSummary>> search(@RequestParam String query) {
        pageNumber = 0;
        refreshBuffer(query);
        return ResponseEntity.status(HttpStatus.OK)
                .body(refreshPage());
    }

    private void refreshBuffer(String query){
        System.out.println(buffer.size());
        buffer.clear();
        List<Product> tempP = null;
        List<Image> tempI = null;

        if(query != null) {
            if(query.length() > 0) {
                tempP = productDB.findByName(query);
            }
            else {
                return;
            }
        }
        else {
            tempP = productDB.findByCategoryId(category.getCategoryid());
            System.out.println(category.getName());
            System.out.println(tempP == null);
            if(tempP != null){
                for(Product p: tempP) {
                    System.out.println(p.getName());
                }
            }
        }

        Collections.sort(tempP);
        if(displayOrder == "Descending"){
            Collections.reverse(tempP);
        }

        convert.productToThumbnail(tempP, buffer);
        totalCount = buffer.size();
        System.out.println(buffer.size());
    }

    private List<ProductSummary> refreshPage() {
        return buffer.subList(pageNumber*itemCount, Math.min(buffer.size(), (pageNumber+1)*itemCount));
    }
}