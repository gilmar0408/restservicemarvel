package com.grupoasd.restservicemarvel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.restservicemarvel.entity.RequestVehicle;
import com.grupoasd.restservicemarvel.entity.ResponseVehicle;
import com.grupoasd.restservicemarvel.entity.ValidationResponse;
import com.grupoasd.restservicemarvel.entity.Vehicle;
import com.grupoasd.restservicemarvel.service.IVehicleService;

@RestController
@RequestMapping("/marvel")
public class vehicleController {

	@Autowired
	private IVehicleService serviceVehicle;

	@PostMapping("/createVehicle")
	public ResponseVehicle create(@RequestBody RequestVehicle request) {

		ResponseVehicle response = new ResponseVehicle();

		ValidationResponse validation = request.isValid();
		if (!validation.isState()) {
			response.setMessage(validation.getMessage());
			return response;
		}

		Vehicle vehicle = new Vehicle();

		vehicle.setVehicleDescription(request.getVehicleDescription());
		response = serviceVehicle.create(vehicle);

		return response;
	}
	
	
	@GetMapping("/getVehicles")
	public  ResponseEntity<List<Vehicle>>    getVehicles(){
		
		List<Vehicle> vehicles = new ArrayList<>();
		
		vehicles = serviceVehicle.list();
		
		
		if(vehicles.isEmpty()) {
			
			return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.NOT_FOUND);
			
			
		}else {
			
			return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
			
		}
		
		
		
	}
	

}
