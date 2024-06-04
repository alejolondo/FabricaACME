package co.com.acme.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.acme.config.ConsumptionConfig;
import co.com.acme.dto.ConsumptionDTO;
import co.com.acme.exeption.DeviceNotFoundException;
import co.com.acme.exeption.InternalServerErrorException;
import co.com.acme.exeption.MissingValueException;
import co.com.acme.exeption.ParameterValidationException;
import co.com.acme.mapper.ConsumptionMapper;
import co.com.acme.model.Consumption;
import co.com.acme.model.Device;
import co.com.acme.repository.ConsumptionRepository;
import co.com.acme.repository.DeviceRepository;
import co.com.acme.service.ConsumptionService;
import co.com.acme.util.Period;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {

	@Autowired
	private ConsumptionRepository repository;

	@Autowired
	private ConsumptionMapper consumptionMapper;

	@Autowired
	private DeviceRepository deviceRepository;

	@Autowired
    private ConsumptionConfig consumptionConfig;

	@Override
	public void createConsumption(ConsumptionDTO consumption) {
	    Device device = consumption.getDevice();
	    Optional<Device> deviceConsumption = deviceRepository.findById(device.getId());

	    if (deviceConsumption.isEmpty()) {
	        throw new ParameterValidationException("The entered device is not registered");
	    }

	    if (Double.isNaN(consumption.getConsumptionValue())) {
	        throw new MissingValueException("The consumption value is missing");
	    }

	    try {
	        repository.save(consumptionMapper.consumptionDTOToConsumption(consumption));
	    } catch (Exception e) {
	        throw new InternalServerErrorException("An internal server error occurred");
	    }
	}



	@Override
    public List<ConsumptionDTO> getConsumptions(Long deviceId, LocalDate date, Period period) {
        
        Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
        if (deviceOptional.isEmpty()) {
            throw new DeviceNotFoundException("Device not found");
        }

        LocalDate startDate;
        LocalDate endDate = date;

        
        switch (period) {
            case DAILY:
                startDate = date.minusDays(1);
                break;
            case  WEEKLY:
                startDate = date.minusWeeks(1);
                break;
            case MONTHLY:
                startDate = date.minusMonths(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid period");
        }

        
        List<Consumption> consumptions = repository.findByDeviceIdAndConsumptionDateBetween(deviceId, startDate, endDate);
        
        
        return  consumptionMapper.listConsumptionToListConsumptionDTO(consumptions);
    }
	
	public List<ConsumptionDTO> getConsumptionPeaks(Long deviceId, LocalDate date, Period period) {
        Optional<Device> deviceOptional = deviceRepository.findById(deviceId);
        if (deviceOptional.isEmpty()) {
            throw new DeviceNotFoundException("Device not found");
        }
        LocalDate startDate;
        LocalDate endDate = date;

        
        switch (period) {
            case DAILY:
                startDate = date.minusDays(1);
                break;
            case  WEEKLY:
                startDate = date.minusWeeks(1);
                break;
            case MONTHLY:
                startDate = date.minusMonths(1);
                break;
            default:
                throw new IllegalArgumentException("Invalid period");
        }

        List<Consumption> consumptions = repository.findByDeviceIdAndConsumptionDateBetween(deviceId, startDate, endDate);
        
        double averageConsumption = consumptions.stream()
                                                .mapToDouble(Consumption::getConsumptionValue)
                                                .average()
                                                .orElse(0);

        double thresholdValue = averageConsumption * (1 + consumptionConfig.getConsumptionThreshold());

        return consumptions.stream()
                           .filter(consumption -> consumption.getConsumptionValue() > thresholdValue)
                           .map(consumptionMapper::consumptionToConsumptionDTO)
                           .collect(Collectors.toList());
    }



	


}
