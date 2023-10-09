package com.example.demo.services;

import com.example.demo.entities.Courses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Courses> getAllCourses();
    Courses getCourseById(int id);
    String addCourse(Courses courses);
    String deleteCourse(int id);
}
