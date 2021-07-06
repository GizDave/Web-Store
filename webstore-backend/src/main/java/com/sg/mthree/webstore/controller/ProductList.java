package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CategoryRepository;
import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Category;
import main.java.com.sg.mthree.webstore.model.dto.Image;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.Thumbnail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    private List<Thumbnail> buffer;
    private List<Category> categoryOption;
    private List<Integer> itemCountOption;
    private List<String> displayOrderOption;

    public ProductList(){
        Integer[] icOption = {10, 15, 20};
        itemCountOption = Arrays.asList(icOption);

        String[] doOption = {"Ascending", "Descending", "None"};
        displayOrderOption = Arrays.asList(doOption);

        categoryOption = categoryDB.findAll();

        pageNumber = 0;
        itemCount = itemCountOption.get(0);
        category = categoryOption.get(0);
        displayOrder = displayOrderOption.get(2);

        refreshBuffer(null);
    }

    @GetMapping("/pageNumber")
    public int getPageNumber(){return pageNumber+1;}
    @GetMapping("/maxPageNumber")
    public int getMaxPageNumber(){return (int) Math.ceil(totalCount/itemCount);}
    @GetMapping("/itemCount")
    public int getItemCount(){return itemCount;}
    @GetMapping("/displayOrder")
    public String getDisplayOrder(){return displayOrder;}
    @GetMapping("/availableItemCounts")
    public List<Integer> getItemCountOption(){return itemCountOption;}
    @GetMapping("/availableDisplayOrders")
    public List<String> getDisplayOrderOption(){return displayOrderOption;}
    @GetMapping("/categories")
    public List<String> getCategories(){return categoryDB.findAllName();}

    @PutMapping("/pageNumber/{newPageNumber}")
    public ResponseEntity<List<Thumbnail>> setPageNumber(@RequestParam int newPageNumber) {
        if(newPageNumber > 0 && newPageNumber * itemCount <= totalCount) {
            this.pageNumber = pageNumber;
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/itemCount/{itemCountIndex}")
    public ResponseEntity<List<Thumbnail>> setItemCount(@RequestParam int itemCountIndex) {
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
    @PutMapping("/displayOrder/{displayOrderIndex}")
    public ResponseEntity<List<Thumbnail>> setDisplayOrder(@RequestParam int displayOrderIndex){
        if(displayOrderIndex >= 0 && displayOrderIndex < itemCountOption.size()) {
            this.displayOrder = displayOrderOption.get(displayOrderIndex);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
    @PutMapping("/categories/{categoryIndex}")
    public ResponseEntity<List<Thumbnail>> setCategory(@RequestParam int categoryIndex) {
        if(categoryIndex >= 0 && categoryIndex < itemCountOption.size()) {
            this.displayOrder = displayOrderOption.get(categoryIndex);
            refreshBuffer(null);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(refreshPage());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }

    @GetMapping("/nextpage")
    public ResponseEntity<List<Thumbnail>> nextPage() {
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

    @GetMapping("/previouspage")
    public ResponseEntity<List<Thumbnail>> prevPage() {
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

    @GetMapping("/search")
    public ResponseEntity<List<Thumbnail>> search(@RequestParam String query) {
        pageNumber = 0;
        refreshBuffer(query);
        return ResponseEntity.status(HttpStatus.OK)
                .body(refreshPage());
    }

    private void refreshBuffer(String query){
        if(query != null && query.length() > 0) {
            return;
        }
        else {
            ArrayList<Thumbnail> tb = new ArrayList<>();
            List<Product> tempP = productDB.findByCategoryId(category.getCategoryid());

            for(Product p: tempP) {

            }
        }

        totalCount = buffer.size();
    }

    private List<Thumbnail> refreshPage() {
        return null;
    }
}