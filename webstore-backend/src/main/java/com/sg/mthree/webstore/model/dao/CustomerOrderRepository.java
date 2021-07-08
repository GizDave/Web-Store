package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Integer> {
    @Query("SELECT co FROM customerorders co WHERE co.customerid = ?1")
    List<CustomerOrder> findAllByCustomerid(int customerId);
}