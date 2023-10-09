package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String duration;

    private double price;

    @ManyToMany
    @JoinTable(
            name = "course_images",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    Set<Images> imagesSet =new HashSet<>();

    public Courses(String name, String duration, double price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public Courses(int id, String name, String duration, double price) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

    public Courses(int id, String name, String duration, double price, Set<Images> imagesSet) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.imagesSet = imagesSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<Images> getImagesSet() {
        return imagesSet;
    }

    public void setImagesSet(Set<Images> imagesSet) {
        this.imagesSet = imagesSet;
    }
}
