package com.grupoasd.restservicemarvel.entity;

public class ResponseStatus {
	
	private String message;
	private ActualStatus actualStatus;
	
	

	public ResponseStatus() {
		
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public ActualStatus getActualStatus() {
		return actualStatus;
	}



	public void setActualStatus(ActualStatus actualStatus) {
		this.actualStatus = actualStatus;
	}
	
	
	

}
