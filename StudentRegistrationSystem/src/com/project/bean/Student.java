package com.project.bean;

public class Student {

	private int roll;
	private String name;
	private String email;
	private String password;
	private String course;
	
	
	
	
	public Student() {
		super();
	}



	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", email=" + email + ", password=" + password + ", course="
				+ course + "]";
	}



	public int getRoll() {
		return roll;
	}



	public void setRoll(int roll) {
		this.roll = roll;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getCourse() {
		return course;
	}



	public void setCourse(String course) {
		this.course = course;
	}



	public Student(int roll, String name, String email, String password, String course) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.password = password;
		this.course = course;
	}
	
	
		
}
