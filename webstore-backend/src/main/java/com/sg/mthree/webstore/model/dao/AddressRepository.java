package com.sg.mthree.webstore.model.dao;

import com.sg.mthree.webstore.model.dto.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
