package com.grupoasd.restservicemarvel.entity;

public class ResponsePlaceOfOperation {
	
	private String message;
	private PlaceOfOperation place;
	

	public ResponsePlaceOfOperation() {
		
	}

	public PlaceOfOperation getPlace() {
		return place;
	}

	public void setPlace(PlaceOfOperation place) {
		this.place = place;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
