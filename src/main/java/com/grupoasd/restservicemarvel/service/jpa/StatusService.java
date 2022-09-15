package com.grupoasd.restservicemarvel.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.restservicemarvel.entity.ResponseStatus;
import com.grupoasd.restservicemarvel.repository.StatusRepository;
import com.grupoasd.restservicemarvel.entity.ActualStatus;
import com.grupoasd.restservicemarvel.service.IStatusService;

@Service
public class StatusService implements IStatusService{
	
	
	@Autowired
	StatusRepository repoStatus;

	@Override
	public ResponseStatus create(ActualStatus status) {
		
		repoStatus.save(status);
		
		ResponseStatus response =  new ResponseStatus();
		
		response.setMessage("Se ha creado exitosamente el estado!.");
		response.setActualStatus(status);
		
		return response;
	}

	@Override
	public void update(ActualStatus status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ActualStatus searchById(int id) {
		
		return repoStatus.findById(id).get();
	}

	@Override
	public List<ActualStatus> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
