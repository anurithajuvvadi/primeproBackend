package com.example.demo.services;

import com.example.demo.entities.Course;

public interface CourseId {
    Course findById(int id);
}
