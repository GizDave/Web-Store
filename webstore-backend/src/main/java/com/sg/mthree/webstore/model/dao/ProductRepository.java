package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Category;
import main.java.com.sg.mthree.webstore.model.dto.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Products p")
    List<Product> findAll();

    @Query("SELECT p FROM Products p WHERE p.name LIKE :query% AND p.categoryid = :categoryid")
    List<Product> findByName(String query, int categoryid);

    @Query("SELECT p FROM Products p WHERE p.categoryid = ?1")
    List<Product> findByCategoryId(int categoryId);
}