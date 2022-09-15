package com.grupoasd.restservicemarvel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="skill")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String skillDescription;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSkillDescription() {
		return skillDescription;
	}


	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}


	@Override
	public String toString() {
		return "Skill [id=" + id + ", skillDescription=" + skillDescription + "]";
	}
	

}
