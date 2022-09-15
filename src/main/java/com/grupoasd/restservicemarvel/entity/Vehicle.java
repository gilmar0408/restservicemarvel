package com.grupoasd.restservicemarvel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String vehicleDescription;
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getVehicleDescription() {
		return vehicleDescription;
	}


	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
	}


	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", vehicleDescription=" + vehicleDescription + "]";
	}
	

}
