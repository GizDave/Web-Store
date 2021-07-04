package com.sg.mthree.webstore.model.dao;

public interface OptionRepository extends JpaRepository<Option,Integer>{
    @Query("SELECT o.stockid FROM Option o WHERE o.optionid = ?1%")
    Integer getStockIdByOptionId(int optionId);
}