package com.grupoasd.restservicemarvel.service;

import java.util.List;

import com.grupoasd.restservicemarvel.entity.ResponseVehicle;
import com.grupoasd.restservicemarvel.entity.Vehicle;

public interface IVehicleService {
	
	ResponseVehicle create (Vehicle vehicle);
	void update (Vehicle vehicle);
	Vehicle searchById(int id);
	List<Vehicle>  list();
	
}
