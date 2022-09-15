package com.grupoasd.restservicemarvel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "superHero")
public class SuperHero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String firstName;

	private String identificationNumber;

	@OneToOne
	@JoinColumn(name = "placeOfOperation")
	private PlaceOfOperation placeOfOperation;

	@OneToOne
	@JoinColumn(name = "tribe")
	private Tribe tribe;

	@OneToOne
	@JoinColumn(name = "actualStatus")
	private ActualStatus actualStatus;

	@OneToOne
	@JoinColumn(name = "skill")
	private Skill skill;

	@OneToOne
	@JoinColumn(name = "vehicle")
	private Vehicle vehicle;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public PlaceOfOperation getPlaceOfOperation() {
		return placeOfOperation;
	}

	public void setPlaceOfOperation(PlaceOfOperation placeOfOperation) {
		this.placeOfOperation = placeOfOperation;
	}

	public Tribe getTribe() {
		return tribe;
	}

	public void setTribe(Tribe tribe) {
		this.tribe = tribe;
	}

	public ActualStatus getActualStatus() {
		return actualStatus;
	}

	public void setActualStatus(ActualStatus actualStatus) {
		this.actualStatus = actualStatus;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "SuperHero [id=" + id + ", firstName=" + firstName + ", placeOfOperation=" + placeOfOperation + ", tribe=" + tribe
				+ ", actualStatus=" + actualStatus + ", skill=" + skill + ", vehicle=" + vehicle + "]";
	}

}
