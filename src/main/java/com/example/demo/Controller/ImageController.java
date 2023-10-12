package com.example.demo.Controller;

import com.example.demo.entities.Image;
import com.example.demo.repo.ImageRepo;
import com.example.demo.servicesimp.CourseServiceImpl;
import com.example.demo.servicesimp.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    CourseServiceImpl courseServiceImp;
    @Autowired
    ImageServiceImpl imageServiceImp;

    @Autowired
    ImageRepo imageRepo;

    @PostMapping("/addImage")
    public String addImage(@RequestParam("file") MultipartFile file, @RequestParam("courseId") int id) throws IOException {
        System.out.println(file);
        System.out.println(id);
        imageServiceImp.addImage(file,id);
        return "";
    }

    @GetMapping("/findByName/{name}")
    public String findByName(@PathVariable String name){
        System.out.println(name);
      Image image =  this.imageRepo.findByName((name));
       if(image!=null){
           return "found";
       }else {
           return "Not Found";
       }
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> getImageFromImages(@PathVariable int id){
        byte[] image = this.imageServiceImp.getImageByIdToData(id);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("media/jpg")).body(image);
    }
}
