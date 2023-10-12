package com.example.demo.Controller;


import com.example.demo.entities.User;
import com.example.demo.servicesimp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        System.out.println(user.getEmail());
        User existingUser = this.userService.getUserByEmail(user.getEmail());
        try {
            if (existingUser != null) {
                return ResponseEntity.status(HttpStatus.OK).body("User Alreadey Exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        userService.registerUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("Registerd");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User existingUser = this.userService.getUserByEmail(user.getEmail());
        if (existingUser != null) {
            System.out.println(existingUser.getPassword().equals(user.getPassword()));
            if (existingUser.getPassword().equals(user.getPassword())) {
                return ResponseEntity.ok(existingUser);
            } else {
                return ResponseEntity.status(400).body("Password Incorrect");
            }
        }
        return ResponseEntity.status(400).body("No User Found");
    }


}
