package com.example.demo.services;

import com.example.demo.entities.Course;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(int id);
    String addCourse(Course course);
    String deleteCourse(int id);

    String courseIdImageId(int courseId, int imageId);

    String addCourse(MultipartFile file,String data) throws IOException;

    String updateCourse(MultipartFile file, String data,int id) throws IOException;
    public byte[] getImageByIdToData(int id);
}
