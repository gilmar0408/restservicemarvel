package com.grupoasd.restservicemarvel.service;

import java.util.List;

import com.grupoasd.restservicemarvel.entity.ResponseSuperHero;
import com.grupoasd.restservicemarvel.entity.SuperHero;

public interface ISuperHeroService {
	
	ResponseSuperHero create (SuperHero superHero);
	void update (SuperHero superHero);
	SuperHero searchById(int id);
	ResponseSuperHero searchByName(String name);
	List<SuperHero>  list ();
	List<SuperHero>  listByPlaceOfOp(int idPlace);

}
