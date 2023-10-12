package com.example.demo.servicesimp;

import com.example.demo.entities.Course;
import com.example.demo.entities.Image;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.ImageRepo;
import com.example.demo.services.CourseId;
import com.example.demo.services.CourseService;
import com.example.demo.services.ImageService;
import com.example.demo.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
@Lazy
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageRepo imageRepo;
    @Autowired
    ImageUtility imageUtility;

    @Autowired
    CourseRepo courseRepo;

    @Override
    public String addImage(MultipartFile file, int id) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setFile(imageUtility.compressImage(file.getBytes()));
        imageRepo.save(image);
        Course course =this.courseRepo.findById(id).orElseThrow(()->new RuntimeException("no course found"));
        Set<Image> imageSet = new HashSet<>();
        for (Image images:course.getImagesSet()){
            imageSet.add(images);
        }
        imageSet.add(image);
        course.setImagesSet(imageSet);
        courseRepo.save(course);
        return "Updated";
    }

    @Override
    public Image getImageById(int id) {
        Image image = this.imageRepo.findById(id).orElseThrow(()->new RuntimeException("not Image Found by this id"));
        return image;
    }

    @Override
    public byte[] getImageByIdToData(int id) {
        Image image = imageRepo.findById(id).orElseThrow(()-> new RuntimeException("not image found"));
        return this.imageUtility.decompressImage(image.getFile());
    }

}
