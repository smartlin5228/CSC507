package com.sample.model;

public class ServiceRequest {

	private String roomservice;
	
	private String servicetime;
	
	private String roomnumber;
	
	private String yname;
	
	public String getroomservice() {
		return roomservice;
	}

	public void setroomservice(String roomservice) {
		this.roomservice = roomservice;
	}

	public String getservicetime() {
		return servicetime;
	}

	public void setservicetime(String servicetime) {
		this.servicetime = servicetime;
	}
	
	public String getroomnumber() {
		return roomnumber;
	}

	public void setroomnumber(String roomnumber) {
		this.roomnumber = roomnumber;
	}
	
	public String getyname() {
		return yname;
	}

	public void setyname(String yname) {
		this.yname = yname;
	}
	
}
