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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/trainers")
public class MyController {
    @Autowired
    ImageUtility imageUtility;
    @Autowired
    private Trainerserviceimpl trainerserviceimpl;

    @Autowired
    private TrainerRepo trainerRepo;


    @GetMapping("/home")
    @PreAuthorize("permitAll()")
    public String home(Principal principal) {
//        System.out.println(principal.getName());
        return "this is my first page";
    }

    //get list of all courses
    @GetMapping("/")
    @PreAuthorize("permitAll()")
    public List<Trainer> getTrainers() {
        return this.trainerserviceimpl.getTrainers();
    }

    //get single course by id
    @GetMapping("/{trainerId}")
    @PreAuthorize("permitAll()")
    public Trainer getTrainerById(@PathVariable String trainerId) {
        return this.trainerserviceimpl.getTrainerById(Long.parseLong(trainerId));
    }

    //adding a new course
    @PostMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addTrainer(@RequestParam("file") MultipartFile file, @RequestParam("trainer") String trainerJson) throws IOException {
//	public ResponseEntity<?> addTrainer(@RequestParam("trainerImg") MultipartFile file, @RequestBody Trainer c) {
    	System.out.println("ON");
    	
        trainerserviceimpl.addTrainer(trainerJson, file);
        return ResponseEntity.status(HttpStatus.OK).body("Created");
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> updateCourse(@RequestParam("file") MultipartFile file, @RequestParam("trainer") String trainerJson, @PathVariable int id) throws IOException {
        this.trainerserviceimpl.updateTrainer(trainerJson, file, id);
        System.out.println();
        return ResponseEntity.status(HttpStatus.OK).body("Data Updated");

    }

    //deleting course
    @DeleteMapping("/{trainerId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String trainerId) {
        try {
            this.trainerserviceimpl.deleteTrainer(Long.parseLong(trainerId));
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/firstname/{firstname}")
    @PreAuthorize("permitAll()")
    public List<Trainer> findByFirstname(@PathVariable String firstname) {
        return this.trainerserviceimpl.findByFirstnameContains(firstname);
    }

    @GetMapping("/lastname/{lastname}")
    @PreAuthorize("permitAll()")
    public List<Trainer> findByLastname(@PathVariable String lastname) {
        return this.trainerserviceimpl.findByLastnameContains(lastname);
    }

    @GetMapping("/findbykey/{key}")
    @PreAuthorize("permitAll()")
    public List<Trainer> findByKey(@PathVariable String key) {
        return this.trainerserviceimpl.findAllByKey(key);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteTrainer(@PathVariable int id) {
        System.out.println(id);
        this.trainerserviceimpl.deleteTrainer((long) id);
        return ResponseEntity.status(HttpStatus.OK).body("Trainer Deleted!!!");
    }

    @GetMapping("/img/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<byte[]> getImageData(@PathVariable int id) {
        byte[] imageData = trainerserviceimpl.getImageData(id);
        System.out.println(imageData);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("media/jpg")).body(imageData);
    }
}
