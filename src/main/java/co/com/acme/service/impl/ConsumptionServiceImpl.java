package co.com.acme.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.acme.dto.ConsumptionDTO;
import co.com.acme.dto.ResponseDTO;
import co.com.acme.mapper.ConsumptionMapper;
import co.com.acme.mapper.DeviceMapper;
import co.com.acme.model.Device;
import co.com.acme.repository.ConsumptionRepository;
import co.com.acme.repository.DeviceRepository;
import co.com.acme.service.ConsumptionService;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {

	@Autowired
	private ConsumptionRepository repository;

	@Autowired
	private ConsumptionMapper consumptionMapper;

	@Autowired
	private DeviceRepository deviceRepository;

	

	@Override
	public void createConsumption(ConsumptionDTO consumption) {
			Device device = consumption.getDevice();
			Optional<Device> deviceConsumption = deviceRepository.findById(device.getId());

			if (deviceConsumption.isEmpty()) {
				throw new IllegalArgumentException("The entered device is not registered");
			}
			repository.save(consumptionMapper.consumptionDTOToConsumption(consumption));
	   
	}

}
