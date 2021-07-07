package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query("SELECT new java.lang.Boolean(CASE WHEN (s.instock = true AND s.quantity > 0) THEN true ELSE false END) FROM Stock s WHERE s.productid = ?1") // not checked against ordered quantity
    Boolean hasStock(int productid);
}