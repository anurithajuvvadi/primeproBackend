package com.example.demo.services;

import java.io.IOException;
import java.util.List;

import com.example.demo.Dao.TrainerDao;
import com.example.demo.entities.Trainer;
import org.springframework.web.multipart.MultipartFile;

public interface Trainerservice {
	public List<Trainer> getTrainers();

	public Trainer getTrainerById(long trainerId);


	Trainer addTrainer(String trainerJson, MultipartFile file) throws IOException;

	public Trainer updateTrainer(String trainerJson,MultipartFile file,long id) throws IOException;

	public void deleteTrainer(long parseLong);
	
	public List<Trainer> findByFirstname(String s);
	
	public List<Trainer> findByLastname(String s);

	//ashish
	public List<Trainer> findByFirstnameContains(String s);
	public List<Trainer> findByLastnameContains(String s);

	public List<Trainer> findAllByKey(String key);

	public byte[] getImageData(long id);

}
