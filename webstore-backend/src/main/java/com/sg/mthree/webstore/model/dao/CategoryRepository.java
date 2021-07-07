package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT c FROM Category c", nativeQuery = true) // prone to duplication
    List<Category> findAll();

    @Query(value = "SELECT c FROM Category c WHERE c.name = ?1", nativeQuery = true)
    Category getCategoryByName(String name);
}