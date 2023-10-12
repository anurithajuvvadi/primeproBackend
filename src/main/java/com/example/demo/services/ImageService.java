package com.example.demo.services;

import com.example.demo.entities.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@Service
public interface ImageService {
    String addImage(MultipartFile file,int id) throws IOException;

    Image getImageById(int id);

    byte[] getImageByIdToData(int id);
}
