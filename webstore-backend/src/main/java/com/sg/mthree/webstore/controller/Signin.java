package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class Signin {
    @Autowired
    private UserRepository userDB;

    @GetMapping
    public ResponseEntity<Integer> login(@RequestParam(name = "Username") String username,
                                         @RequestParam(name = "Password") String password) {
        Integer userId = userDB.login(username, password);

        if(userId == null) {
            return ResponseEntity.badRequest()
                    .body(0);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userId);
        }
    }
}