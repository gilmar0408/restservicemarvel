package com.grupoasd.restservicemarvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.restservicemarvel.entity.PlaceOfOperation;
import com.grupoasd.restservicemarvel.entity.RequestPlace;
import com.grupoasd.restservicemarvel.entity.ResponsePlaceOfOperation;
import com.grupoasd.restservicemarvel.service.IPlaceOfOperationService;

@RestController
@RequestMapping("/marvel")
public class PlaceOfOperationController {
	
	
	@Autowired
	IPlaceOfOperationService  servicePlace;
	
	
	
	
	@PostMapping("/createPlace")
	public ResponseEntity<ResponsePlaceOfOperation>  create (@RequestBody RequestPlace request) {
		
		ResponsePlaceOfOperation response = new ResponsePlaceOfOperation();
		PlaceOfOperation place = new PlaceOfOperation();
		
		place.setPlaceDescription(request.getPlaceDescription());
		
		response = servicePlace.create(place);
		
		return new ResponseEntity<ResponsePlaceOfOperation>(response, HttpStatus.OK);
	}
	

}
