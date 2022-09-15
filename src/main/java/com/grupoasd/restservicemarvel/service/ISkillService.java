package com.grupoasd.restservicemarvel.service;

import java.util.List;

import com.grupoasd.restservicemarvel.entity.ResponseSkill;
import com.grupoasd.restservicemarvel.entity.Skill;

public interface ISkillService {
	
	ResponseSkill  create(Skill skill);
	void  update(Skill skill);
	Skill searchById (int id);
	List<Skill>   list();
	
}
