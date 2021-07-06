package com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Login {
    @Autowired
    private UserRepository userDB;

    @GetMapping
    public Integer login(@RequestParam(name = "Username") String username,
                         @RequestParam(name = "Password") String password){
        return userDB.login(username, password);
    }
}