package com.example.demo.services;

import com.example.demo.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(int id);
    String addCourse(Course course);
    String deleteCourse(int id);

    String courseIdImageId(int courseId, int imageId);
}
