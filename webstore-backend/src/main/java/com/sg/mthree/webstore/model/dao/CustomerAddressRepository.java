package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Address;
import main.java.com.sg.mthree.webstore.model.dto.CustomerAddressBridge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddressBridge,Integer> {
    @Query("SELECT cab.Address FROM CustomerAddressBridge cab WHERE cab.customerid = ?1")
    Address findAddressByCustomerId(int customerid);
}