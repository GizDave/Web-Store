package com.sg.mthree.webstore.model.dao;

public interface StockRepository extends JpaRepository<Stock,Integer>{
    @Query("SELECT CASE WHEN s.instock = true THEN s.quantity ELSE null END FROM Stock s WHERE s.stockid = ?1%",
            nativeQuery = true)
    Integer getAvailableOptionStock(int stockId);
}