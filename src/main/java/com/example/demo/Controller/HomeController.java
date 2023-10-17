package com.example.demo.Controller;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/home")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

    @Autowired
    UserRepo userRepo;
    @GetMapping("/")
    public ResponseEntity<?> homeGet(Principal principal){
        try{
        System.out.println(principal.getName());

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Welcome to home page");
//        User user = userRepo.findByEmail(principal.getName()).orElseThrow(()-> new RuntimeException("user User Found"));
        return ResponseEntity.status(HttpStatus.OK).body("user");
    }
}
