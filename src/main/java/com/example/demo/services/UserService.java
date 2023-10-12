package com.example.demo.services;

import com.example.demo.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User registerUser(User user);
    User getUserByEmail(String email);

}
