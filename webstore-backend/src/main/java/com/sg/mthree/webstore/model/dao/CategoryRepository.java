package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Categories c") // prone to duplication
    List<Category> findAll();

    @Query(value = "SELECT c FROM Categories c WHERE c.name = ?1", nativeQuery = true)
    List<Category> getCategoryByName(String name);
}