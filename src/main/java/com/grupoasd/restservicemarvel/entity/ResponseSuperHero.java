package com.grupoasd.restservicemarvel.entity;

public class ResponseSuperHero {
	
	
	private String message;
	private SuperHero  superHero;
	
	public ResponseSuperHero() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public SuperHero getSuperHero() {
		return superHero;
	}

	public void setSuperHero(SuperHero superHero) {
		this.superHero = superHero;
	}
	

}
