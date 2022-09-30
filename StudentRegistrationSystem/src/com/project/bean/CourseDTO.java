package com.project.bean;

public class CourseDTO {

	private int cid;
	private String cname;
	private int batch;
	private int fee;
	private int totalseats;
	private int seatsfilled;
	private int seatsAvailable;
	
	
	
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



	public int getSeatsfilled() {
		return seatsfilled;
	}



	public void setSeatsfilled(int seatsfilled) {
		this.seatsfilled = seatsfilled;
	}



	public int getSeatsAvailable() {
		return seatsAvailable;
	}



	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}



	public CourseDTO() {
		super();
	}



	public CourseDTO(int cid, String cname, int batch, int fee, int totalseats, int seatsfilled, int seatsAvailable) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.batch = batch;
		this.fee = fee;
		this.totalseats = totalseats;
		this.seatsfilled = seatsfilled;
		this.seatsAvailable = seatsAvailable;
	}



	@Override
	public String toString() {
		return "CourseId: " + cid + " Course name: " + cname + " Batch :" + batch + "\nTotal Seats: "
				+ totalseats + " Seats Filled: " + seatsfilled + " Seats Available: " + seatsAvailable;
	}
	
	
	
}
