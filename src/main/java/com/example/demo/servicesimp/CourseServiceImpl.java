package com.example.demo.servicesimp;

import com.example.demo.entities.Course;
import com.example.demo.repo.CourseRepo;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;
//    @Autowired
//    ImageServiceImpl imageServiceImp;


    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return null;
    }

    @Override
    public String addCourse(Course course) {
        Course courses = this.courseRepo.save(course);
        return "Record saved";
    }

    @Override
    public String deleteCourse(int id) {
        return null;
    }

    @Override
    public String courseIdImageId(int courseId, int imageId) {
        Course course = getCourseById(courseId);
//        Image image = this.imageServiceImp.getImageById(imageId);
//        Set<Image> imageSet = new HashSet<>();
//        imageSet.add(image);
//        course.setImagesSet(imageSet);
        addCourse(course);
        return "Image Added";
    }
}
