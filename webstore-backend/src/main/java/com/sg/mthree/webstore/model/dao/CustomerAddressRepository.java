package com.sg.mthree.webstore.model.dao;

import com.sg.mthree.webstore.model.dto.Address;
import com.sg.mthree.webstore.model.dto.CustomerAddressBridge;
import com.sg.mthree.webstore.model.dto.CustomerAddressBridgeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressBridge, CustomerAddressBridgeId> {
    @Query(value = "SELECT cab.Address FROM Customer_Address_Bridge cab WHERE cab.customerid = ?1", nativeQuery = true)
    List<Address> getAddressByCustomerId(int customerid);
}