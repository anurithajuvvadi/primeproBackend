package com.example.demo.repo;

import com.example.demo.entities.TokenData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepo extends JpaRepository<TokenData , Integer> {
}
