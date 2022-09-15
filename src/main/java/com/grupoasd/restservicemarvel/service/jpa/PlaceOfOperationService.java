package com.grupoasd.restservicemarvel.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.restservicemarvel.entity.PlaceOfOperation;
import com.grupoasd.restservicemarvel.entity.ResponsePlaceOfOperation;
import com.grupoasd.restservicemarvel.repository.PlaceOfOperationRepository;
import com.grupoasd.restservicemarvel.service.IPlaceOfOperationService;

@Service
public class PlaceOfOperationService implements IPlaceOfOperationService{
	
	@Autowired
	PlaceOfOperationRepository  repoPlace;
	

	@Override
	public ResponsePlaceOfOperation create(PlaceOfOperation placeOfOperation) {
		
		repoPlace.save(placeOfOperation);
		
		ResponsePlaceOfOperation response = new ResponsePlaceOfOperation();
		
		response.setMessage("Se ha creado exitosamente el lugar de operación!.");
		response.setPlace(placeOfOperation);
		
		return response;
	}

	@Override
	public void update(PlaceOfOperation placeOfOperation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlaceOfOperation searchById(int id) {
		
		return repoPlace.findById(id).get();
	}

	@Override
	public List<PlaceOfOperation> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
