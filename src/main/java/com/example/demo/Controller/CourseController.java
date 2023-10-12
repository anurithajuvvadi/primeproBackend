package com.example.demo.Controller;

import com.example.demo.entities.Course;
import com.example.demo.servicesimp.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseServiceImpl courseServiceImp;

    @GetMapping("/")
    public List<Course> courses() {
      List<Course> course =  this.courseServiceImp.getAllCourses();
        System.out.println(course);
        return course;
    }

    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        System.out.println(course.toString());
        courseServiceImp.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Course Added");
    }
}
