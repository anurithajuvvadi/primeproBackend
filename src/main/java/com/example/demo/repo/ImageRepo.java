package com.example.demo.repo;

import com.example.demo.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<Image,Integer> {
    Image findByName(String name);
}
