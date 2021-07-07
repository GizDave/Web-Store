package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("SELECT c FROM Category c") // prone to duplication
    List<Category> findAll();

    @Query("SELECT c FROM Category c WHERE c.name = ?1")
    Category getCategoryByName(String name);
}