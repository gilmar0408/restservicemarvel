package com.grupoasd.restservicemarvel.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.restservicemarvel.entity.Tribe;
import com.grupoasd.restservicemarvel.repository.GroupRepository;
import com.grupoasd.restservicemarvel.entity.ResponseGroup;
import com.grupoasd.restservicemarvel.service.IGroupService;

@Service
public class GroupService implements IGroupService{
	
	@Autowired
	GroupRepository repoGroup;
	

	@Override
	public ResponseGroup create(Tribe group) {
		
		ResponseGroup response = new ResponseGroup();
		repoGroup.save(group);
		
		response.setMessage("Se ha registrado el grupo exitosamente!.");
		response.setTribe(group);
		
		return response;
	}

	@Override
	public void update(Tribe group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tribe searchById(int id) {
		
		return repoGroup.findById(id).get();
	}

	@Override
	public List<Tribe> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
