package com.example.demo.Controller;

import com.example.demo.entities.Course;
import com.example.demo.servicesimp.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseServiceImpl courseServiceImp;

    @GetMapping("/")
    public List<Course> courses() {
      List<Course> course =  this.courseServiceImp.getAllCourses();
        return course;
    }
    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestParam("file") MultipartFile file, @RequestParam("data") String  courseDataSring) throws IOException {
        courseServiceImp.addCourse(file,courseDataSring);
        return ResponseEntity.status(HttpStatus.OK).body("Course Added");
    }
    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<?> addCourse(@RequestParam("file") MultipartFile file,
                                       @RequestParam("data") String  courseDataSring,
                                       @PathVariable("id") int id) throws IOException {
        courseServiceImp.updateCourse(file,courseDataSring,id);
        return ResponseEntity.status(HttpStatus.OK).body("Course Added");
    }
    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String > deleteCourse(@PathVariable("id") int id){
        this.courseServiceImp.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Course Successfully");
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> getImageFromImages(@PathVariable int id){
        byte[] image = this.courseServiceImp.getImageByIdToData(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("media/jpg")).body(image);
    }

    @GetMapping("/getCourseById/{id}")
    public Course getCourseById(@PathVariable("id") int id){
        Course course = this.courseServiceImp.getCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body(course).getBody();
    }

}
