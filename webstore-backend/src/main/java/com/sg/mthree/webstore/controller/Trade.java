package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CustomerAddressRepository;
import main.java.com.sg.mthree.webstore.model.dao.CustomerPaymentRepository;
import main.java.com.sg.mthree.webstore.model.dao.CustomerRepository;
import main.java.com.sg.mthree.webstore.model.dto.Customer;
import main.java.com.sg.mthree.webstore.model.dto.CustomerPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/trade")
public class Trade {
    @Autowired
    private CustomerRepository customerDB;

    @Autowired
    private CustomerPaymentRepository customerPaymentDB;

    @Autowired
    private CustomerAddressRepository customerAddressDB;

    private Customer customer;

    @GetMapping("/prefill")
    public Optional<CustomerPayment> getCustomer(@RequestParam("CustomerId") int userId) {
        int customerId = customerDB.getCustomerIdByUserId(userId);
        return customerPaymentDB.findById(customerId);
    }

    @PostMapping("/buy")
    public ResponseEntity<String> addOrder(){

    }

    @PutMapping("/editorder")
    public ResponseEntity<String> editOrder(){

    }

    @DeleteMapping("/deleteorder")
    public ResponseEntity<String> deleteOrder(){

    }
}