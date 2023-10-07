package com.example.demo.Controller;

import java.util.List;

import com.example.demo.repo.TrainerRepo;
import com.example.demo.servicesimp.Trainerserviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.Trainer;
import com.example.demo.services.Trainerservice;

import jakarta.transaction.Transaction;

@RestController
public class MyController {
//	@Autowired
//	private Trainerservice tservice;

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
	public List<Trainer> getTrainers(){
		return this.trainerserviceimpl.getTrainers();
	}
	
	//get single course by id
	@GetMapping("trainers/{trainerId}")
	public Trainer getTrainerById(@PathVariable String trainerId) {
		return this.trainerserviceimpl.getTrainerById(Long.parseLong(trainerId));
		
	}
	//adding a new course
	@PostMapping("/trainers")
	public ResponseEntity<?> addTrainer(@RequestBody Trainer c) {
//		System.out.println(c);
//		Trainer trainer = new Trainer();
////		trainer.setFirstname(c.getFirstname());
////		trainer.setLastname(c.getLastname());
////		trainer.setEmailid(c.getEmailid());
////		this.trainerserviceimpl.addTrainer(c);
//		trainerRepo.save(c);
		trainerserviceimpl.addTrainer(c);
		return ResponseEntity.status(HttpStatus.OK).body("Created");
//		return this.trainerserviceimpl.addTrainer(c);
		
		
	}
	//updating course using put mapping
	@PutMapping("/trainers")
	public Trainer updateCourse(@RequestBody Trainer c) {
		return this.trainerserviceimpl.updateTrainer(c);
		
	}
	//deleting course
	@DeleteMapping("/trainers/{trainerId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String trainerId){
		try {
		this.trainerserviceimpl.deleteTrainer(Long.parseLong(trainerId));
		return new ResponseEntity<>(HttpStatus.OK);
		
		}catch(Exception e ) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/trainers/firstname/{firstname}")
	public List<Trainer> findByFirstname(@PathVariable String firstname){ 
		return this.trainerserviceimpl.findByFirstnameContains(firstname);
//		return this.trainerserviceimpl.findByFirstname(firstname);

	}
	
	@GetMapping("/trainers/lastname/{lastname}")
	public List<Trainer> findByLastname(@PathVariable String lastname){ 
		return this.trainerserviceimpl.findByLastnameContains(lastname);
//		return this.trainerserviceimpl.findByLastname(lastname);

	}
	@GetMapping("/trainers/findbykey/{key}")
	public List<Trainer> findByKey(@PathVariable String key){
		return this.trainerserviceimpl.findAllByKey(key);
//		return this.trainerserviceimpl.findByLastname(lastname);

	}

	@DeleteMapping ("/trainers/delete/{id}")
	public ResponseEntity<?> deleteTrainer(@PathVariable int id){
		System.out.println(id);
	 	this.trainerserviceimpl.deleteTrainer((long)id);
		 return  ResponseEntity.status(HttpStatus.OK).body("Trainer Deleted!!!");
	}


}
