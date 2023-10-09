package com.example.demo.servicesimp;

import com.example.demo.entities.Courses;
import com.example.demo.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Override
    public List<Courses> getAllCourses() {
        return null;
    }

    @Override
    public Courses getCourseById(int id) {
        return null;
    }

    @Override
    public String addCourse(Courses courses) {
        return null;
    }

    @Override
    public String deleteCourse(int id) {
        return null;
    }
}
