package com.grupoasd.restservicemarvel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupoasd.restservicemarvel.entity.ActualStatus;

public interface StatusRepository extends JpaRepository<ActualStatus, Integer>{
	

}
