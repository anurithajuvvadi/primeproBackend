package com.example.demo.Controller;

import com.example.demo.entities.User;
import com.example.demo.servicesimp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImp;

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        User user = this.userServiceImp.getUserByEmailId(email);
        return user;
    }
}
