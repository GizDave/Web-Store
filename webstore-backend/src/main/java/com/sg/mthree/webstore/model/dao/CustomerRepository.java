package com.sg.mthree.webstore.model.dao;

import com.sg.mthree.webstore.model.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT c.customerid FROM Customers c WHERE c.userid = ?1", nativeQuery = true)
    List<Integer> getCustomerIdByUserId(int userId);
}