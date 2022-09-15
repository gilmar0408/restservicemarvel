package com.grupoasd.restservicemarvel.entity;

public class ValidationResponse {
	
	private String message;
	private boolean state;
	
	public ValidationResponse() {
		
	}
	
	public ValidationResponse(String message , boolean state ) {
		
		this.message = message;
		this.state = state;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "ValidationResponse [message=" + message + ", state=" + state + "]";
	}
	
	

}
