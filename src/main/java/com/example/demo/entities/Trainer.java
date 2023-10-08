package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Trainer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstname;
	private String lastname;
	private String emailid;
	private  String designation;
	private String qualification;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] img;


	public Trainer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trainer(long id, String firstname, String lastname, String emailid, String designation, String qualification, byte[] img) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailid = emailid;
		this.designation = designation;
		this.qualification = qualification;
		this.img = img;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Trainer{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", emailid='" + emailid + '\'' +
				", designation='" + designation + '\'' +
				", qualification='" + qualification + '\'' +
				", img=" + Arrays.toString(img) +
				'}';
	}
}
