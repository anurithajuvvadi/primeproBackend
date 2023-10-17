package com.example.demo.services;

import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User registerUser(User user);
    User getUserByEmailId(String email);

}
