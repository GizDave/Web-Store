package com.sg.mthree.webstore.controller;

import com.sg.mthree.webstore.model.dao.CustomerRepository;
import com.sg.mthree.webstore.model.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class Signin {
    @Autowired
    private UserRepository userDB;

    @Autowired
    private CustomerRepository customerDB;

    @GetMapping
    public ResponseEntity<Integer> login(@RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password) {
        Integer userId = userDB.login(username, password).get(0);

        if(userId == null) {
            return ResponseEntity.badRequest()
                    .body(0);
        }
        else {
            Integer customerId = customerDB.getCustomerIdByUserId(userId).get(0);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(customerId);
        }
    }
}