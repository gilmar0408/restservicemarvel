package com.grupoasd.restservicemarvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.restservicemarvel.entity.ActualStatus;
import com.grupoasd.restservicemarvel.entity.RequestActualStatus;
import com.grupoasd.restservicemarvel.entity.ResponseStatus;
import com.grupoasd.restservicemarvel.service.IStatusService;

@RestController
@RequestMapping("/marvel")
public class StatusController {
	
	@Autowired
	private IStatusService serviceStatus;
	
	
	@PostMapping("/createStatus")
	public ResponseEntity<ResponseStatus>  create (@RequestBody RequestActualStatus request){
		
		ResponseStatus response = new ResponseStatus();
		
		ActualStatus s = new ActualStatus();
		
		s.setStatusDescription(request.getStatusDescription());
		
		response = serviceStatus.create(s);
		
		return new ResponseEntity<ResponseStatus>(response, HttpStatus.OK);
	}
	
	
	

}
