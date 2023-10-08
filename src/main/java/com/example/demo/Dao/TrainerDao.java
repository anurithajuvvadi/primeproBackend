package com.example.demo.Dao;

import java.util.Arrays;

public class TrainerDao {


    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String firstname;
    private String lastname;
    private String emailid;
    private  String designation;
    private String qualification;

    @Override
    public String toString() {
        return "TrainerDao{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailid='" + emailid + '\'' +
                ", designation='" + designation + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
