package com.example.demo.servicesimp;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public User registerUser(User user) {
        System.out.println(user);
        User user1 = new User();
        user1.setEmail(user.getEmail());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));
        user1.setRole(user.getRole());
        User user2 = this.userRepo.save(user1);
        return user;
    }


    public User getUserByEmailId(String email) {
        User user = this.userRepo.findByEmail(email).orElseThrow(()-> new RuntimeException("user not found"));
        return user;
    }
}
