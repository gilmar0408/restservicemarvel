package com.grupoasd.restservicemarvel.service;

import java.util.List;

import com.grupoasd.restservicemarvel.entity.PlaceOfOperation;
import com.grupoasd.restservicemarvel.entity.ResponsePlaceOfOperation;

public interface IPlaceOfOperationService {
	
	ResponsePlaceOfOperation  create(PlaceOfOperation  placeOfOperation);
	void update(PlaceOfOperation  placeOfOperation);
	PlaceOfOperation  searchById(int id);
	List<PlaceOfOperation>   list();

}
