package com.example.demo.repo;

import com.example.demo.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses,Integer> {


}
