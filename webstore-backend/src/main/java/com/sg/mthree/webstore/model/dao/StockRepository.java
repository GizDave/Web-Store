package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    @Query(value = "SELECT s.stockid FROM Stock s WHERE s.productid = ?1", nativeQuery = true)
    Integer findByProductId(int productid);
}