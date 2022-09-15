package com.grupoasd.restservicemarvel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupoasd.restservicemarvel.entity.RequestSkill;
import com.grupoasd.restservicemarvel.entity.ResponseSkill;
import com.grupoasd.restservicemarvel.entity.Skill;
import com.grupoasd.restservicemarvel.service.ISkillService;

@RestController
@RequestMapping("/marvel")
public class SkillController {
	
	@Autowired
	private ISkillService  serviceSkill;
	
	
	@PostMapping("/createSkill")
	public ResponseEntity<ResponseSkill> create (@RequestBody RequestSkill request){
		
		ResponseSkill response = new ResponseSkill();
		
		Skill skill = new Skill();
		
		skill.setSkillDescription(request.getSkillDescription());
		
		response = serviceSkill.create(skill);
		
		return  new ResponseEntity<ResponseSkill>(response, HttpStatus.OK);
	}
	
	

}
