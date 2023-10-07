package com.example.demo.servicesimp;


import com.example.demo.entities.Trainer;
import com.example.demo.repo.TrainerRepo;
import com.example.demo.services.Trainerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Trainerserviceimpl implements Trainerservice {
//	@Autowired
//	private TrainerDao tdao;

	@Autowired
	TrainerRepo trainerRepo;
	
	public Trainerserviceimpl() {}

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
	public Trainer addTrainer(Trainer c) {
		// TODO Auto-generated method stub
		trainerRepo.save(c);
		return c;
	}

	@Override
	public Trainer updateTrainer(Trainer c) {
		// TODO Auto-generated method stub
		trainerRepo.save(c);
		return c;
	}

	@Override
	public void deleteTrainer(long parseLong) {
		// TODO Auto-generated method stub
		trainerRepo.deleteById(parseLong);
	}
	public List<Trainer> findByFirstname(String s)
	{
		List<Trainer> c1=trainerRepo.findByFirstname(s);
		c1.forEach(e->System.out.println(e));
		return c1;
		
		}
	
	public List<Trainer> findByLastname(String s)
	{
		List<Trainer> c1=trainerRepo.findByLastname(s);
		c1.forEach(e->System.out.println(e));
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


}
