package com.grupoasd.restservicemarvel.service;

import java.util.List;

import com.grupoasd.restservicemarvel.entity.ResponseStatus;
import com.grupoasd.restservicemarvel.entity.ActualStatus;

public interface IStatusService {
	
	ResponseStatus create(ActualStatus status);
	void update (ActualStatus status);
	ActualStatus searchById (int id);
	List<ActualStatus>  list();

}
