package co.com.acme.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import co.com.acme.dto.ConsumptionDTO;

public interface ConsumptionService {
	
	
	public void createConsumption(ConsumptionDTO consumption);
	
	public List<ConsumptionDTO> getConsumptions(Long deviceId, LocalDate date, String period);

}
