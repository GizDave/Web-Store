package com.sg.mthree.webstore.model.dao;

import com.sg.mthree.webstore.model.dto.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("SELECT i from Images i WHERE i.productid = ?1")
    List<Image> findByProductId(int productId);
}
