package com.example.demo.Controller;

import com.example.demo.entities.User;
import com.example.demo.servicesimp.UserServiceImpl;
import com.example.demo.utils.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@PreAuthorize("permitAll()")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImp;
    @Autowired
    JWTUtility jwtUtility;

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email){
        User user = this.userServiceImp.getUserByEmailId(email);
        return user;
    }

    @GetMapping("/userFromToken/{token}")
    public User  userByToken(@PathVariable String token){
        String  user = jwtUtility.getUsernameFromToken(token);
        User user1 = getUserByEmail(user);
        return user1;
    }
}
