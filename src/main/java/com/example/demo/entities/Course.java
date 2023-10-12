package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String duration;

    private int price;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] file;

    private String filename;

//    @ManyToMany
//    @JoinTable(
//            name = "course_images",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "image_id")
//    )
//    Set<Image> imageSet =new HashSet<>();


    public Course(int id, String name, String duration, int price) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
    }

   public Course(){

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

    public void setPrice(int price) {
        this.price = price;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Course(int id, String name, String duration, int price, byte[] file, String filename) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.file = file;
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                ", file=" + Arrays.toString(file) +
                ", filename='" + filename + '\'' +
                '}';
    }
//    public Set<Image> getImagesSet() {
//        return imageSet;
//    }
//
//    public void setImagesSet(Set<Image> imageSet) {
//        this.imageSet = imageSet;
//    }
}
