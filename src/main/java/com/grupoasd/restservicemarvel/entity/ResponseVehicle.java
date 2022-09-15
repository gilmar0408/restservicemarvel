package com.grupoasd.restservicemarvel.entity;

public class ResponseVehicle {
	
	private String message;
	private Vehicle vehicle;
	

	public ResponseVehicle() {
		
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
}
