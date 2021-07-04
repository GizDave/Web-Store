package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    // get popular products by number of units ordered (not the best metric)
    @Query("SELECT p from Product p WHERE p.productid IN (SELECT productid FROM Customer_Order_Product_Bridge GROUP BY productid SORT BY SUM(quantity) DESC LIMIT ?1)")
    List<Product> findByPopularity(int num_product);

    @Query("SELECT p from Product p WHERE p.name LIKE ?1% ORDER BY p.name ?4 OFFSET ?2*?3 LIMIT ?3")
    List<Product> findByName(String name, int page_num, int num_product, String order);

    // pagination
    @Query("SELECT p from Product p ORDER BY p.?1 ?4 ORDER BY p.name ?4 OFFSET ?2*?3 LIMIT ?3")
    List<Product> nextBatch(String filter, int page_num, int num_product, String order);
}