package com.example.demo.Controller;

import com.example.demo.Dao.TrainerDao;
import com.example.demo.entities.Trainer;
import com.example.demo.repo.TrainerRepo;
import com.example.demo.servicesimp.Trainerserviceimpl;
import com.example.demo.utils.ImageUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    ImageUtility imageUtility;
    @Autowired
    private Trainerserviceimpl trainerserviceimpl;

    @Autowired
    private TrainerRepo trainerRepo;


    @GetMapping("/home")
    public String home() {
        return "this is my first page";
    }

    //get list of all courses
    @GetMapping("/trainers")
    public List<Trainer> getTrainers() {
        return this.trainerserviceimpl.getTrainers();
    }

    //get single course by id
    @GetMapping("trainers/{trainerId}")
    public Trainer getTrainerById(@PathVariable String trainerId) {
        return this.trainerserviceimpl.getTrainerById(Long.parseLong(trainerId));
    }

    //adding a new course
    @PostMapping("/trainers")
    public ResponseEntity<?> addTrainer(@RequestParam("file") MultipartFile file, @RequestParam("trainer") String trainerJson) throws IOException {
//	public ResponseEntity<?> addTrainer(@RequestParam("trainerImg") MultipartFile file, @RequestBody Trainer c) {
        trainerserviceimpl.addTrainer(trainerJson, file);
        return ResponseEntity.status(HttpStatus.OK).body("Created");
    }

    @PutMapping("/trainers/update/{id}")
    public ResponseEntity<String> updateCourse(@RequestParam("file") MultipartFile file, @RequestParam("trainer") String trainerJson, @PathVariable int id) throws IOException {
        this.trainerserviceimpl.updateTrainer(trainerJson,file,id);
        System.out.println();
        return ResponseEntity.status(HttpStatus.OK).body("Data Updated");

    }

    //deleting course
    @DeleteMapping("/trainers/{trainerId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String trainerId) {
        try {
            this.trainerserviceimpl.deleteTrainer(Long.parseLong(trainerId));
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/trainers/firstname/{firstname}")
    public List<Trainer> findByFirstname(@PathVariable String firstname) {
        return this.trainerserviceimpl.findByFirstnameContains(firstname);
    }

    @GetMapping("/trainers/lastname/{lastname}")
    public List<Trainer> findByLastname(@PathVariable String lastname) {
        return this.trainerserviceimpl.findByLastnameContains(lastname);
    }

    @GetMapping("/trainers/findbykey/{key}")
    public List<Trainer> findByKey(@PathVariable String key) {
        return this.trainerserviceimpl.findAllByKey(key);
    }

    @DeleteMapping("/trainers/delete/{id}")
    public ResponseEntity<?> deleteTrainer(@PathVariable int id) {
        System.out.println(id);
        this.trainerserviceimpl.deleteTrainer((long) id);
        return ResponseEntity.status(HttpStatus.OK).body("Trainer Deleted!!!");
    }

    @GetMapping("/trainers/img/{id}")
    public ResponseEntity<byte[]> getImageData(@PathVariable int id){
     byte[] imageData = trainerserviceimpl.getImageData(id);
        System.out.println(imageData);
     return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("media/jpg")).body(imageData);
    }
}
