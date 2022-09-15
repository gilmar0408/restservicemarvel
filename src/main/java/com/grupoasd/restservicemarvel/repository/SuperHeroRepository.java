package com.grupoasd.restservicemarvel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.grupoasd.restservicemarvel.entity.SuperHero;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer>{
	
	@Query(value = "SELECT * FROM superHero WHERE superHero.firstName LIKE %:filter%" 
			, nativeQuery = true)
	List<SuperHero> searchByName(@Param("filter")  String filter);
	
	
	
	@Query(value = "SELECT * FROM superHero WHERE superHero.placeOfOperation = ?1"
			, nativeQuery = true)
	List<SuperHero> searchByPlace(int idPlace);

}
