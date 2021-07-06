package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment,Integer> {
    @Query("SELECT cp FROM CustomerPayment cp WHERE cp.customerid = ?1")
    List<CustomerPayment> findByCustomerId(int customerId);
}