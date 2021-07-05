package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.CustomerPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPaymentRepository extends JpaRepository<CustomerPayment,Integer> {

}