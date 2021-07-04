package com.sg.mthree.webstore.model.dao;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
    @Query("SELECT c.customerid FROM Customer c WHERE c.userid = ?1")
    Integer getCustomerIdByUserId(int userId);
}