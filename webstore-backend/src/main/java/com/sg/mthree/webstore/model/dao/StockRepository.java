package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query("SELECT s.stockid FROM Stock s WHERE s.productid = ?1")
    Integer findByProductId(int productid);
}