package com.grupoasd.restservicemarvel.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.restservicemarvel.entity.ResponseVehicle;
import com.grupoasd.restservicemarvel.entity.Vehicle;
import com.grupoasd.restservicemarvel.repository.VehicleRepository;
import com.grupoasd.restservicemarvel.service.IVehicleService;


@Service
public class VehicleService implements IVehicleService {

	@Autowired
	VehicleRepository repoVehicle;

	@Override
	public ResponseVehicle create(Vehicle vehicle) {

		boolean isPresent = false;
		ResponseVehicle response = new ResponseVehicle();

		List<Vehicle> vehicles = repoVehicle.findAll();

		for (Vehicle v : vehicles) {

			if (v.getVehicleDescription().equalsIgnoreCase(vehicle.getVehicleDescription())) {

				isPresent = true;

				break;
			}

		}

		if (!isPresent) {

			repoVehicle.save(vehicle);

			response.setVehicle(vehicle);
			response.setMessage("Vehiculo registrado exitosamente!");

		}else {
			
			response.setMessage("El vehiculo ya se encuentra registrado.");
			
		}

		return response;
	}

	@Override
	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vehicle searchById(int id) {
		
		return repoVehicle.findById(id).get();
	}

	@Override
	public List<Vehicle> list() {
		
		return repoVehicle.findAll();
	}

}
