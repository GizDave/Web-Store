package com.sg.mthree.webstore.controller;

import com.sg.mthree.webstore.model.dao.CustomerPaymentRepository;
import com.sg.mthree.webstore.model.dao.CustomerRepository;
import com.sg.mthree.webstore.model.dao.UserRepository;
import com.sg.mthree.webstore.model.dto.Customer;
import com.sg.mthree.webstore.model.dto.CustomerPayment;
import com.sg.mthree.webstore.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userprofile")
@CrossOrigin(origins = "*")
public class Profile {
    @Autowired
    private UserRepository userDB;

    @Autowired
    private CustomerRepository customerDB;

    @Autowired
    private CustomerPaymentRepository customerPaymentDB;

    @GetMapping("/basic/get/{customerId}")
    public ResponseEntity<Customer> getBasicInformation(@RequestParam int customerId){
        Optional<Customer> c = customerDB.findById(customerId);
        if(!c.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(c.get());
        }
    }

    @GetMapping("/paymentInformation/get/{customerId}")
    public ResponseEntity<List<CustomerPayment>> getPaymentInformation(@RequestParam int customerId){
        Optional<List<CustomerPayment>> cp = Optional.ofNullable(customerPaymentDB.findByCustomerId(customerId));
        if(!cp.isPresent()) {
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(cp.get());
        }
    }

    @GetMapping("/securityInformation/get/{customerId}")
    public ResponseEntity<User> getSecurityInformation(@RequestParam int customerId){
        Optional<Customer> c = customerDB.findById(customerId);
        if(!c.isPresent()){
            return ResponseEntity.badRequest()
                    .body(null);
        }
        Optional<User> u = userDB.findById(c.get().getUserid());
        if(!u.isPresent()){
            return ResponseEntity.badRequest()
                    .body(null);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(u.get());
        }
    }
}
