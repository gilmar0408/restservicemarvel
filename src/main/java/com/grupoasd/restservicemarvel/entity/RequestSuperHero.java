package com.grupoasd.restservicemarvel.entity;

public class RequestSuperHero {

	private String firstName;
	private String identificationNumber;
	private String idPlace;
	private String idTribe;
	private String idActualStatus;
	private String idSkill;
	private String idVehicle;

	public ValidationResponse isValid() {

		ValidationResponse validation = new ValidationResponse();

		if ( this.firstName == null  || this.idPlace == null ||  this.idTribe == null || this.idActualStatus == null
				|| this.idSkill == null || this.idVehicle == null  || this.identificationNumber == null) {

			validation.setState(false);
			validation.setMessage("Por favor validar , los datos se encuentran nulos");

		} else if (this.firstName.isEmpty() || this.idPlace.isEmpty() || this.idTribe.isEmpty() || this.idActualStatus.isEmpty()
				|| this.idSkill.isEmpty() || this.idVehicle.isEmpty() || this.identificationNumber.isEmpty()){

			
			validation.setState(false);
			validation.setMessage("Por favor validar , los datos se encuentran vacios");

		}else {
			
			validation.setState(true);
			validation.setMessage("Valores correctos");
			
		}

		return validation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(String idPlace) {
		this.idPlace = idPlace;
	}

	public String getIdTribe() {
		return idTribe;
	}

	public void setIdTribe(String idTribe) {
		this.idTribe = idTribe;
	}

	public String getIdActualStatus() {
		return idActualStatus;
	}

	public void setIdActualStatus(String idActualStatus) {
		this.idActualStatus = idActualStatus;
	}

	public String getIdSkill() {
		return idSkill;
	}

	public void setIdSkill(String idSkill) {
		this.idSkill = idSkill;
	}

	public String getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(String idVehicle) {
		this.idVehicle = idVehicle;
	}

}
