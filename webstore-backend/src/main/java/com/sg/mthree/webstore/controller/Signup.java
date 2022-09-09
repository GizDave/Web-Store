package main.java.com.sg.mthree.webstore.controller;

import main.java.com.sg.mthree.webstore.model.dao.UserRepository;
import main.java.com.sg.mthree.webstore.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signup")
public class Signup {
    @Autowired
    private UserRepository userDB;

    private final int min_username_len = 6;
    private final int max_username_len = 20;
    private final int min_password_len = 6;
    private final int max_password_len = 20;

    @PostMapping
    public ResponseEntity<String> register(@RequestParam String username,
                                           @RequestParam String password) {
        // no cleaning punctuations
        username = username.trim();
        password = password.trim();
        if(userDB.existsByUsername(username) ) {
            return ResponseEntity.badRequest()
                    .body("Username already exists. Choose another one.");
        }
        else {
            if(username.length() < min_username_len || username.length() > max_username_len) {
                return ResponseEntity.badRequest()
                        .body(String.format("Username (after trimming spaces) must be within the length of %d and %d, inclusively.",
                                min_username_len, max_username_len));
            }

            User u = new User();
            u.setUsername(username);
            u.setPassword(password);
            userDB.save(u);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("User added.");
        }
    }

    @GetMapping("/admin/getUserList")
    public ResponseEntity<List<User>> getUserList(@RequestParam int userId) {
        if (userDB.existsById(userId) && userDB.findById(userId).get().isAdmin()){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(userDB.findAll());
        }
        else {
            return ResponseEntity.badRequest()
                    .body(null);
        }
    }
}
