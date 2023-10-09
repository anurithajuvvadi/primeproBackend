package com.example.demo.repo;

import com.example.demo.entities.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Images,Integer> {
}
