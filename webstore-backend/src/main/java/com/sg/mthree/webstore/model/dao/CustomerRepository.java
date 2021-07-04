package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("SELECT c.customerid FROM Customer c WHERE c.userid = ?1")
    Integer getCustomerIdByUserId(int userId);
}