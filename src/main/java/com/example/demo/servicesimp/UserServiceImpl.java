package com.example.demo.servicesimp;

import com.example.demo.entities.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public User registerUser(User user) {
        User user1 = this.userRepo.save(user);
        return user1;
    }

    @Override
    public User getUserByEmail(String email) {
        User user = this.userRepo.findByEmail(email);
        return user;
    }
}
