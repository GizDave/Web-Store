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
    private Map<String, Sort.Direction> displayOrderOptionMap;

    private Converter convert;

    public ProductList(){
        Integer[] icOption = {10, 15, 20};
        itemCountOption = Arrays.asList(icOption);
        System.out.println("itemcountoption");
        String[] doOption = {"Ascending", "Descending", "None"};
        displayOrderOption = Arrays.asList(doOption);
        displayOrderOptionMap = new HashMap<String, Sort.Direction>();
        displayOrderOptionMap.put("Ascending", Sort.Direction.ASC);
        displayOrderOptionMap.put("Descending", Sort.Direction.DESC);
        displayOrderOptionMap.put("None", Sort.Direction.ASC); // default sort order
        System.out.println("displayorderoptionmap");
        categoryOption = categoryDB.findAll();
        System.out.println("categoryoption");
        pageNumber = 0;
        itemCount = itemCountOption.get(0);
        category = categoryOption.get(0);
        displayOrder = displayOrderOption.get(2);
        System.out.println("basic stats");
        refreshBuffer(null);
        System.out.println("refreshbuffer");
        convert = new Converter();
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
    public List<Category> getCategories(){return categoryOption;}

    @PutMapping("/pageNumber/{newPageNumber}")
    public ResponseEntity<List<ProductSummary>> setPageNumber(@RequestParam int newPageNumber) {
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
    @PutMapping("/displayOrder/{displayOrderIndex}")
    public ResponseEntity<List<ProductSummary>> setDisplayOrder(@RequestParam int displayOrderIndex){
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
    public ResponseEntity<List<ProductSummary>> setCategory(@RequestParam String categoryName) {
        Category temp = categoryDB.getCategoryByName(categoryName);
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
        buffer = new ArrayList<>();
        List<Product> tempP = null;
        List<Image> tempI = null;

        if(query != null) {
            if(query.length() > 0) {
                tempP = productDB.findByName(
                        query,
                        Sort.by(displayOrderOptionMap.get(displayOrder), "name")
                );
            }
            else {
                return;
            }
        }
        else {
            tempP = productDB.findByCategoryId(
                    category.getCategoryid(),
                    Sort.by(displayOrderOptionMap.get(displayOrder), "name")
            );
        }

        buffer = convert.productToThumbnail(tempP);
        totalCount = buffer.size();
    }

    private List<ProductSummary> refreshPage() {
        return buffer.subList(pageNumber*itemCount, Math.min(buffer.size(), (pageNumber+1)*itemCount));
    }
}