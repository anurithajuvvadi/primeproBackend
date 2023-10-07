package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Trainer;

public interface Trainerservice {
	public List<Trainer> getTrainers();

	public Trainer getTrainerById(long trainerId);

	public Trainer addTrainer(Trainer c);

	public Trainer updateTrainer(Trainer c);

	public void deleteTrainer(long parseLong);
	
	public List<Trainer> findByFirstname(String s);
	
	public List<Trainer> findByLastname(String s);

	//ashish
	public List<Trainer> findByFirstnameContains(String s);
	public List<Trainer> findByLastnameContains(String s);

	public List<Trainer> findAllByKey(String key);

}
