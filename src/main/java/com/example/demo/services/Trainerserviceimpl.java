package com.example.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.TrainerDao;
import com.example.demo.entities.Trainer;

@Service
public class Trainerserviceimpl implements Trainerservice {
	@Autowired
	private TrainerDao tdao;
	
	public Trainerserviceimpl() {}

	@Override
	public List<Trainer> getTrainers() {
		// TODO Auto-generated method stub
		return tdao.findAll();
	}

	@Override
	public Trainer getTrainerById(long trainerId) {
		// TODO Auto-generated method stub
		return tdao.findById(trainerId).get();
	}

	@Override
	public Trainer addTrainer(Trainer c) {
		// TODO Auto-generated method stub
		tdao.save(c);
		return c;
	}

	@Override
	public Trainer updateTrainer(Trainer c) {
		// TODO Auto-generated method stub
		tdao.save(c);
		return c;
	}

	@Override
	public void deleteTrainer(long parseLong) {
		// TODO Auto-generated method stub
		Trainer entity=tdao.getOne(parseLong);
		tdao.delete(entity);
		
	}
	public List<Trainer> findByFirstname(String s)
	{
		List<Trainer> c1=tdao.findByFirstname(s);
		c1.forEach(e->System.out.println(e));
		return c1;
		
		}
	
	public List<Trainer> findByLastname(String s)
	{
		List<Trainer> c1=tdao.findByLastname(s);
		c1.forEach(e->System.out.println(e));
		return c1;
		
		}
	
	

}
