package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.CustomerAddressBridge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressBridge,Integer> {

}