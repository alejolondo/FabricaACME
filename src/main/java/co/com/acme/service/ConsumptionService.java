package co.com.acme.service;

import co.com.acme.dto.ResponseDTO;
import co.com.acme.model.Consumption;

public interface ConsumptionService {
	
	
	public ResponseDTO createConsumption(Consumption consumption);

}
