package co.com.acme.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.com.acme.dto.ConsumptionDTO;
import co.com.acme.model.Consumption;

@Mapper(componentModel = "spring")
public interface ConsumptionMapper {
	
	ConsumptionDTO consumptionToConsumptionDTO(Consumption consumption);
	
	Consumption consumptionDTOToConsumption(ConsumptionDTO consumptionDTO);
	
	List<ConsumptionDTO> listConsumptionToListConsumptionDTO(List<Consumption> consumptions);
	
	List<Consumption> listConsumptionDTOToListConsumption(List<ConsumptionDTO> consumptionsDTO);

}
