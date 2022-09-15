package com.grupoasd.restservicemarvel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.restservicemarvel.entity.Tribe;
import com.grupoasd.restservicemarvel.entity.PlaceOfOperation;
import com.grupoasd.restservicemarvel.entity.RequestSuperHero;
import com.grupoasd.restservicemarvel.entity.ResponseSuperHero;
import com.grupoasd.restservicemarvel.entity.Skill;
import com.grupoasd.restservicemarvel.entity.ActualStatus;
import com.grupoasd.restservicemarvel.entity.SuperHero;
import com.grupoasd.restservicemarvel.entity.ValidationResponse;
import com.grupoasd.restservicemarvel.entity.Vehicle;
import com.grupoasd.restservicemarvel.service.IGroupService;
import com.grupoasd.restservicemarvel.service.IPlaceOfOperationService;
import com.grupoasd.restservicemarvel.service.ISkillService;
import com.grupoasd.restservicemarvel.service.IStatusService;
import com.grupoasd.restservicemarvel.service.ISuperHeroService;
import com.grupoasd.restservicemarvel.service.IVehicleService;

@RestController
@RequestMapping("/marvel")
public class SuperHeroController {

	@Autowired
	private ISuperHeroService serviceSuperHero;

	@Autowired
	private IVehicleService serviceVehicle;

	@Autowired
	private IStatusService serviceStatus;

	@Autowired
	private ISkillService serviceSkill;

	@Autowired
	private IPlaceOfOperationService servicePlaceOfOperation;

	@Autowired
	private IGroupService serviceGroup;

	@PostMapping("/createSuperHero")
	public ResponseEntity<ResponseSuperHero> create(@RequestBody RequestSuperHero request) {
		ResponseSuperHero response = new ResponseSuperHero();
		
		

		ValidationResponse validation = request.isValid();

		if (!validation.isState()) {

			response.setMessage(validation.getMessage());
			System.out.println("se ha realizado la validación");
			return  new ResponseEntity<ResponseSuperHero>(response, HttpStatus.BAD_REQUEST);

		}

		SuperHero superHero = new SuperHero();
		superHero.setFirstName(request.getFirstName());
		superHero.setIdentificationNumber(request.getIdentificationNumber());
		PlaceOfOperation place = servicePlaceOfOperation.searchById(Integer.parseInt(request.getIdPlace()));
		Tribe group = serviceGroup.searchById(Integer.parseInt(request.getIdTribe()));
		ActualStatus actualStatus = serviceStatus.searchById(Integer.parseInt(request.getIdActualStatus()));
		Skill skill = serviceSkill.searchById(Integer.parseInt(request.getIdSkill()));
		Vehicle vehicle = serviceVehicle.searchById(Integer.parseInt(request.getIdVehicle()));

		superHero.setPlaceOfOperation(place);
		superHero.setTribe(group);
		superHero.setActualStatus(actualStatus);
		superHero.setSkill(skill);
		superHero.setVehicle(vehicle);
		
		response = serviceSuperHero.create(superHero);

		return  new ResponseEntity<ResponseSuperHero>(response, HttpStatus.CREATED);

	}

	@GetMapping("/getSuperHeros")
	public  ResponseEntity<List<SuperHero>>    getSuperHeros() {

		List<SuperHero> superHeros = serviceSuperHero.list();
		
		if(superHeros.isEmpty()) {
			
			return new ResponseEntity<List<SuperHero>>(superHeros, HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<List<SuperHero>>(superHeros, HttpStatus.OK);
		}

		
	}

	@GetMapping("/searchSHByName/{name}")
	public  ResponseEntity<ResponseSuperHero>   searchSHByName(@PathVariable("name") String name) {

		ResponseSuperHero response = new ResponseSuperHero();

		response = serviceSuperHero.searchByName(name);
		
		if(response.getSuperHero() == null) {
			
			return new ResponseEntity<ResponseSuperHero>(response, HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<ResponseSuperHero>(response, HttpStatus.OK);
			
		}

		
	}

	@GetMapping("/searchSHByPlace/{idPlace}")
	public  ResponseEntity<List<SuperHero>>  searchSHByPlace(@PathVariable("idPlace") int idPlace) {

		List<SuperHero> superHeros = new ArrayList<>();

		superHeros = serviceSuperHero.listByPlaceOfOp(idPlace);
		
		
		if(superHeros.isEmpty()) {
			
			return new ResponseEntity<List<SuperHero>>(superHeros, HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<List<SuperHero>>(superHeros, HttpStatus.OK);
		}

		
	}

	@PutMapping("/updateSuperHero/{id}")
	public ResponseEntity<ResponseSuperHero> updateSuperHero(@RequestBody RequestSuperHero request, @PathVariable("id") int id) {

		ResponseSuperHero response = new ResponseSuperHero();
		
		ValidationResponse validation = request.isValid();

		if (!validation.isState()) {

			response.setMessage(validation.getMessage());
			System.out.println("se ha realizado la validación");
			return  new ResponseEntity<ResponseSuperHero>(response, HttpStatus.BAD_REQUEST);

		}
		
		
		

		SuperHero s = serviceSuperHero.searchById(id);

		if (s != null) {

			s.setTribe(serviceGroup.searchById(Integer.parseInt(request.getIdTribe())));
			s.setIdentificationNumber(request.getIdentificationNumber());
			s.setFirstName(request.getFirstName());
			s.setPlaceOfOperation(servicePlaceOfOperation.searchById(Integer.parseInt(request.getIdPlace())));
			s.setSkill(serviceSkill.searchById(Integer.parseInt(request.getIdSkill())));
			s.setActualStatus(serviceStatus.searchById(Integer.parseInt(request.getIdActualStatus())));
			s.setVehicle(serviceVehicle.searchById(Integer.parseInt(request.getIdVehicle())));
			
			serviceSuperHero.update(s);
			
			response.setMessage("Se ha actualizado correctamente el super Heroe!.");
			response.setSuperHero(s);

		} else {

			response.setMessage("No se ha actualizado , El super heroe no ha sido encontrado.");
			return new ResponseEntity<ResponseSuperHero>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ResponseSuperHero>(response, HttpStatus.OK);
	}

}
