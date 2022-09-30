package com.project.bean;

public class StudentDTO {

	private int roll;
	private String email;
	private String name;
	private String cname;
	private int cid;
	private int batch;
	private int fee;
	
	
	public StudentDTO() {
		super();
	}


	public StudentDTO(int roll, String email, String name, String cname, int cid, int batch, int fee) {
		super();
		this.roll = roll;
		this.email = email;
		this.name = name;
		this.cname = cname;
		this.cid = cid;
		this.batch = batch;
		this.fee = fee;
	}


	public int getRoll() {
		return roll;
	}


	public void setRoll(int roll) {
		this.roll = roll;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getBatch() {
		return batch;
	}


	public void setBatch(int batch) {
		this.batch = batch;
	}


	public int getFee() {
		return fee;
	}


	public void setFee(int fee) {
		this.fee = fee;
	}


	@Override
	public String toString() {
		return "CourseID : "+cid +"   Course name : "+cname+"   Batch : "+batch+"\nRoll No : "+ roll +"\nName : "+name+"\nEmail : "+email+"\nFees : "+fee; 
		
	}
	
	
	
	
}
