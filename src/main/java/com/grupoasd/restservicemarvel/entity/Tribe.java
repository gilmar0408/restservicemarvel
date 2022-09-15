package com.grupoasd.restservicemarvel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tribe")
public class Tribe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String tribeDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTribeDescription() {
		return tribeDescription;
	}

	public void setTribeDescription(String tribeDescription) {
		this.tribeDescription = tribeDescription;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", tribeDescription=" + tribeDescription + "]";
	}


}
