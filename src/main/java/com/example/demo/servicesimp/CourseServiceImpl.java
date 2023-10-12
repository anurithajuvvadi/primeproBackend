package com.example.demo.servicesimp;

import com.example.demo.Dao.CourseDao;
import com.example.demo.entities.Course;
import com.example.demo.repo.CourseRepo;
import com.example.demo.services.CourseService;
import com.example.demo.utils.ImageUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Lazy
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;
//    @Autowired
//    ImageServiceImpl imageServiceImp;

    @Autowired
    ImageUtility imageUtility;


    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return  this.courseRepo.findById(id).orElseThrow(()-> new RuntimeException("No Course Found"));
    }

    @Override
    public String addCourse(Course course) {
        Course courses = this.courseRepo.save(course);
        return "Record saved";
    }

    @Override
    public String deleteCourse(int id) {
        this.courseRepo.deleteById(id);
        return "Deleted";
    }

    @Override
    public String courseIdImageId(int courseId, int imageId) {
        Course course = getCourseById(courseId);
        addCourse(course);
        return "Image Added";
    }

    @Override
    public String addCourse(MultipartFile file, String data) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CourseDao courseDao=null;
        courseDao = objectMapper.readValue(data,CourseDao.class);
        Course course = new Course();
        course.setName(courseDao.getName());
        course.setDuration(courseDao.getDuration());
        course.setPrice((courseDao.getPrice()));
        course.setFile(imageUtility.compressImage(file.getBytes()));
        course.setFilename(file.getOriginalFilename());

        courseRepo.save(course);

        return "SuccessFull";
    }

    @Override
    public String updateCourse(MultipartFile file, String data,int id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CourseDao courseDao=null;
        courseDao = objectMapper.readValue(data,CourseDao.class);
        Course course = this.getCourseById(id);
        course.setId(course.getId());
        course.setName(courseDao.getName());
        course.setDuration(courseDao.getDuration());
        course.setPrice((courseDao.getPrice()));
        if(file.isEmpty())
        course.setFile(course.getFile());
        if(!file.isEmpty())
        course.setFile(imageUtility.compressImage(file.getBytes()));
        course.setFilename(file.getOriginalFilename());

        courseRepo.save(course);

        return "SuccessFull";
    }

    @Override
    public byte[] getImageByIdToData(int id) {
        Course course= courseRepo.findById(id).orElseThrow(()-> new RuntimeException("not image found"));
        return this.imageUtility.decompressImage(course.getFile());
    }
}
