package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment, Integer> {
    @Query(value = "SELECT cp FROM CustomerPayment cp WHERE cp.customerid = ?1", nativeQuery = true)
    List<CustomerPayment> findByCustomerId(int customerId);
}