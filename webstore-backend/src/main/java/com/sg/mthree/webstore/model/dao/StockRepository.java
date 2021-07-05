package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock,Integer> {
    @Query("SELECT CASE WHEN s.instock = true THEN s.quantity ELSE null END FROM Stock s WHERE s.stockid = ?1")
    Integer getAvailableOptionStock(int stockId);
}