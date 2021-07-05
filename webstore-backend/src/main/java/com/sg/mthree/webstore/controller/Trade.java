package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.CustomerRepository;
import main.java.com.sg.mthree.webstore.model.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/trade")
public class Trade {
    @Autowired
    private CustomerRepository customerDB;

    @GetMapping("/prefill")
    public Optional<Customer> getCustomer(@RequestParam("CustomerId") int userId) {
        int customerId = customerDB.getCustomerIdByUserId(userId);
        return customerDB.findById(customerId);
    }
}