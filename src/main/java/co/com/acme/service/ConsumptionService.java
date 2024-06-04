package co.com.acme.service;

import java.time.LocalDate;
import java.util.List;

import co.com.acme.dto.ConsumptionDTO;
import co.com.acme.util.Period;

public interface ConsumptionService {
	
	
	public void createConsumption(ConsumptionDTO consumption);
	
	public List<ConsumptionDTO> getConsumptions(Long deviceId, LocalDate date, Period period);
	
	List<ConsumptionDTO> getConsumptionPeaks(Long deviceId, LocalDate date, Period period);

}
