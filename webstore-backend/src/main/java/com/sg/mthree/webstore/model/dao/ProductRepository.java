package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    // get popular products by number of units ordered (not the best metric)
    @Query(value = "SELECT p FROM Product p WHERE p.productid IN (SELECT productid FROM Customer_Order_Product_Bridge GROUP BY productid SORT BY SUM(quantity) DESC LIMIT ?1)", nativeQuery = true)
    List<Product> findByPopularity(int num_product);

    @Query("SELECT p FROM Product p WHERE p.name LIKE ?1%")
    List<Product> findByName(String query, Sort sort);

    @Query("SELECT p FROM Product p WHERE p.categoryid = ?1")
    List<Product> findByCategoryId(int categoryId, Sort sort);
}