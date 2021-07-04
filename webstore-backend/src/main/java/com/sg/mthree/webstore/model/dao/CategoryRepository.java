package com.sg.mthree.webstore.model.dao;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    @Query("SELECT DISTINCT c.name FROM Category c ORDER BY p.name ?1%",
            nativeQuery = true)
    List<String> findAllName(String order);
}