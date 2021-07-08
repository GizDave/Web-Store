package main.java.com.sg.mthree.webstore.model.dao;

import main.java.com.sg.mthree.webstore.model.dto.Address;
import main.java.com.sg.mthree.webstore.model.dto.CustomerAddressBridge;
import main.java.com.sg.mthree.webstore.model.dto.CustomerAddressBridgeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressBridge, CustomerAddressBridgeId> {
    @Query(value = "SELECT cab.addressid FROM customeraddressbridge cab WHERE cab.customerid = ?1")
    List<Integer> getAddressIdByCustomerId(int customerid);
}