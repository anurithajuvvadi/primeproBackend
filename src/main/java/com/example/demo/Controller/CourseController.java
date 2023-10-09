package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/")
public class CourseController {

@GetMapping("/")
    public ResponseEntity<?> courses(){
    return ResponseEntity.status(HttpStatus.OK).body( "Welcome to home");
}

}
