package com.example.demo.repo;

import com.example.demo.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerRepo extends JpaRepository<Trainer,Long> {

    public List<Trainer> findByFirstname(String s);

    public List<Trainer> findByLastname(String s);
    public List<Trainer> findByFirstnameContains(String s);
    public List<Trainer> findByLastnameContains(String s);

    @Query("SELECT t FROM Trainer t WHERE t.firstname LIKE %?1%"
        + "OR t.lastname LIKE %?1% OR t.emailid LIKE %?1%")
    public List<Trainer> findAllByKey(String key);


}
