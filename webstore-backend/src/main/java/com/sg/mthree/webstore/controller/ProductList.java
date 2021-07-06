package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CategoryRepository;
import main.java.com.sg.mthree.webstore.model.dao.ImageRepository;
import main.java.com.sg.mthree.webstore.model.dao.ProductRepository;
import main.java.com.sg.mthree.webstore.model.dto.Category;
import main.java.com.sg.mthree.webstore.model.dto.Image;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import main.java.com.sg.mthree.webstore.model.dto.Thumbnail;
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

    private List<Thumbnail> buffer;
    private List<Category> categoryOption;
    private List<Integer> itemCountOption;
    private List<String> displayOrderOption;
    private Map<String, Sort.Direction> displayOrderOptionMap;

    public ProductList(){
        Integer[] icOption = {10, 15, 20};
        itemCountOption = Arrays.asList(icOption);

        String[] doOption = {"Ascending", "Descending", "None"};
        displayOrderOption = Arrays.asList(doOption);
        displayOrderOptionMap = new HashMap<String, Sort.Direction>();
        displayOrderOptionMap.put("Ascending", Sort.Direction.ASC);
        displayOrderOptionMap.put("Descending", Sort.Direction.DESC);
        displayOrderOptionMap.put("None", Sort.Direction.ASC); // default sort order

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

    @GetMapping("/search/{query}")
    public ResponseEntity<List<Thumbnail>> search(@RequestParam String query) {
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

        for(Product p: tempP) {
            Thumbnail tn = new Thumbnail();
            tn.setProductid(p.getProductid());
            tn.setName(p.getName());
            tn.setDescription(p.getDescription());

            tempI = imageDB.findByProductId(p.getProductid());
            if(tempI.size() > 0){
                tn.setImage_path(tempI.get(0).getImage_path()); // default to first image of the product
            }

            buffer.add(tn);
        }

        totalCount = buffer.size();
    }

    private List<Thumbnail> refreshPage() {
        return buffer.subList(pageNumber*itemCount, Math.min(buffer.size(), (pageNumber+1)*itemCount));
    }
}