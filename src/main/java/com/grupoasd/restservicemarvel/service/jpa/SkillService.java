package com.grupoasd.restservicemarvel.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.restservicemarvel.entity.ResponseSkill;
import com.grupoasd.restservicemarvel.entity.Skill;
import com.grupoasd.restservicemarvel.repository.SkillRepository;
import com.grupoasd.restservicemarvel.service.ISkillService;

@Service
public class SkillService implements ISkillService{
	
	
	@Autowired
	SkillRepository repoSkill;

	@Override
	public ResponseSkill create(Skill skill) {
		
		
		repoSkill.save(skill);
		ResponseSkill response = new ResponseSkill();
		
		response.setMessage("Se ha creado la habilidad exitosamente!.");
		response.setSkill(skill);
		
		return response;
	}

	@Override
	public void update(Skill skill) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Skill searchById(int id) {
		
		return repoSkill.findById(id).get();
	}

	@Override
	public List<Skill> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
