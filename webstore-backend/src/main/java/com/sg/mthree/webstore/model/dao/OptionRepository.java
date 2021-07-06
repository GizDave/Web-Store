package com.sg.mthree.webstore.model.dao;

import com.sg.mthree.webstore.model.dto.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OptionRepository extends JpaRepository<Option,Integer> {
    @Query("SELECT o.stockid FROM Option o WHERE o.optionid = ?1")
    Integer getStockIdByOptionId(int optionId);
}