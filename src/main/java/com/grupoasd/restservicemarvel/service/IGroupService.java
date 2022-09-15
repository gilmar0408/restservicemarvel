package com.grupoasd.restservicemarvel.service;

import java.util.List;

import com.grupoasd.restservicemarvel.entity.Tribe;
import com.grupoasd.restservicemarvel.entity.ResponseGroup;

public interface IGroupService {
	
	ResponseGroup create(Tribe group);
	void update (Tribe group);
	Tribe  searchById(int id);
	List<Tribe>  list();
	
}
