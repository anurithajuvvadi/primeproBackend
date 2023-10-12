package com.example.demo.interview;

public class Employee {
    String name;
    String email;
    int age;
    int id;

    Employee (String  name,String email,int age,int id){
        this.name = name;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    @Override
    public String toString(){
        return "name" + name + "email "+email+ "age "+ age + "id "+ id;
    }
}
