package com.sg.mthree.webstore.model.dao;

import com.sg.mthree.webstore.model.dto.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // get popular products by number of units ordered (not the best metric)
    @Query(value = "SELECT p FROM Products p WHERE p.productid IN (SELECT cop.productid FROM Customer_Order_Product_Bridge cop GROUP BY cop.productid SORT BY SUM(cop.quantity) DESC LIMIT ?1)", nativeQuery = true)
    List<Product> findByPopularity(int num_product);

    @Query(value = "SELECT p FROM Products p WHERE p.name LIKE ?1%", nativeQuery = true)
    List<Product> findByName(String query);

    @Query(value = "SELECT p FROM Products p WHERE p.categoryid = ?1", nativeQuery = true)
    List<Product> findByCategoryId(int categoryId);
}