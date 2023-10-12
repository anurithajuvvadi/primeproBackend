package com.example.demo.Dao;

public class CourseDao {

    private String name;
    private String duration;

    private int price;

    public CourseDao(){

    }

    public String getName() {
        return name;
    }

    public CourseDao(String name, String duration, int price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CourseDao{" +
                "name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", price=" + price +
                '}';
    }
}
