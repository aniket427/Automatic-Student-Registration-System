package com.project.bean;

public class Course {
	private int cid;
	private String cname;
	private int batch;
	private int fee;
	private int totalseats;
	
	
	public Course(int cid, String cname, int batch, int fee, int totalseats) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.batch = batch;
		this.fee = fee;
		this.totalseats = totalseats;
	}


	public Course() {
		super();
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCname() {
		return cname;
	}


	public void setCname(String cname) {
		this.cname = cname;
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


	public int getTotalseats() {
		return totalseats;
	}


	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}


	@Override
	public String toString() {
		return "Course ID -> " + cid + ", Course Name -> " + cname + ", Batch No. -> " + batch + ", Fees -> " + fee + ", Total Seats -> "
				+ totalseats;
	}
	
	
}
