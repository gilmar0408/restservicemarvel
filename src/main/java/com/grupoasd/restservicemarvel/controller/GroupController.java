package com.grupoasd.restservicemarvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.restservicemarvel.entity.RequestGroup;
import com.grupoasd.restservicemarvel.entity.ResponseGroup;
import com.grupoasd.restservicemarvel.entity.Tribe;
import com.grupoasd.restservicemarvel.service.IGroupService;

@RestController
@RequestMapping("/marvel")
public class GroupController {

	@Autowired
	private IGroupService serviceGroup;

	@PostMapping("/createGroup")
	public ResponseEntity<ResponseGroup> create(@RequestBody RequestGroup request) {

		Tribe tribe = new Tribe();

		tribe.setTribeDescription(request.getTribeDescription());

		ResponseGroup response = serviceGroup.create(tribe);

		return new ResponseEntity<ResponseGroup>(response, HttpStatus.OK);
	}

}
