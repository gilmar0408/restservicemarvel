package com.grupoasd.restservicemarvel.entity;

public class RequestVehicle {

	private String vehicleDescription;

	public ValidationResponse isValid() {

		ValidationResponse validation = new ValidationResponse();

		if (this.vehicleDescription.isEmpty() || this.vehicleDescription == null) {

			validation.setState(false);
			validation.setMessage("Los campos se encuentran vacios.");

		}
		
		validation.setMessage("valores correctos");
		validation.setState(true);

		return validation;
	}

	public String getVehicleDescription() {
		return vehicleDescription;
	}

	public void setVehicleDescription(String vehicleDescription) {
		this.vehicleDescription = vehicleDescription;
	}
	
	

}
