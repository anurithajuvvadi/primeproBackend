package com.example.demo.servicesimp;


import com.example.demo.Dao.TrainerDao;
import com.example.demo.entities.Trainer;
import com.example.demo.repo.TrainerRepo;
import com.example.demo.services.Trainerservice;
import com.example.demo.utils.ImageUtility;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class Trainerserviceimpl implements Trainerservice {
    @Autowired
    ImageUtility imageUtility;
    @Autowired
    TrainerRepo trainerRepo;

    @Override
    public List<Trainer> getTrainers() {
        // TODO Auto-generated method stub
        return trainerRepo.findAll();
    }

    @Override
    public Trainer getTrainerById(long trainerId) {
        // TODO Auto-generated method stub
        return trainerRepo.findById(trainerId).get();
    }

    @Override
    public Trainer addTrainer(String trainerJson, MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TrainerDao trainer = null;

        try {
            trainer = objectMapper.readValue(trainerJson, TrainerDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Trainer trainer1 = new Trainer();
        trainer1.setFirstname(trainer.getFirstname());
        trainer1.setLastname(trainer.getLastname());
        trainer1.setEmailid(trainer.getEmailid());
        trainer1.setDesignation(trainer.getDesignation());
        trainer1.setQualification(trainer.getQualification());
        trainer1.setImg(imageUtility.compressImage(file.getBytes()));
        trainerRepo.save(trainer1);
        return trainer1;
    }

    @Override
    public Trainer updateTrainer(String trainerJson, MultipartFile file, long id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TrainerDao trainer = null;
        try {
            trainer = objectMapper.readValue(trainerJson, TrainerDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Trainer trainer1 = trainerRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        trainer1.setId(trainer.getId());
        trainer1.setFirstname(trainer.getFirstname());
        trainer1.setLastname(trainer.getLastname());
        trainer1.setEmailid(trainer.getEmailid());
        trainer1.setDesignation(trainer.getDesignation());
        trainer1.setQualification(trainer.getQualification());
        if (file.isEmpty())
            trainer1.setImg(trainer1.getImg());
        if (!file.isEmpty())
            trainer1.setImg(imageUtility.compressImage(file.getBytes()));
        trainerRepo.save(trainer1);
        return trainer1;
    }

    @Override
    public void deleteTrainer(long parseLong) {
        // TODO Auto-generated method stub
        trainerRepo.deleteById(parseLong);
    }

    public List<Trainer> findByFirstname(String s) {
        List<Trainer> c1 = trainerRepo.findByFirstname(s);
        c1.forEach(e -> System.out.println(e));
        return c1;

    }

    public List<Trainer> findByLastname(String s) {
        List<Trainer> c1 = trainerRepo.findByLastname(s);
        c1.forEach(e -> System.out.println(e));
        return c1;

    }

    @Override
    public List<Trainer> findByFirstnameContains(String s) {
        List<Trainer> trainers = trainerRepo.findByFirstnameContains(s);
        return trainers;
    }

    @Override
    public List<Trainer> findByLastnameContains(String s) {
        List<Trainer> trainers = trainerRepo.findByLastnameContains(s);
        return trainers;
    }

    @Override
    public List<Trainer> findAllByKey(String key) {
        List<Trainer> trainers = trainerRepo.findAllByKey(key);
        return trainers;
    }

    @Override
    public byte[] getImageData(long id) {
        Optional<Trainer> trainer = trainerRepo.findById(id);
        return imageUtility.decompressImage(trainer.get().getImg());
    }


}
