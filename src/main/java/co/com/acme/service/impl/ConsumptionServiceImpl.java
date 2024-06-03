package co.com.acme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.acme.dto.ResponseDTO;
import co.com.acme.mapper.ConsumptionMapper;
import co.com.acme.model.Consumption;
import co.com.acme.repository.ConsumptionRepository;
import co.com.acme.service.ConsumptionService;

@Service
public class ConsumptionServiceImpl implements ConsumptionService{
	
	@Autowired
	private ConsumptionRepository repository;
	
	

	@Override
	public ResponseDTO createConsumption(Consumption consumption) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			repository.save(consumption);
			responseDTO.setCode(200);
			responseDTO.setMessage("Registro guardado exitosamente");
		}catch(Exception e) {
			responseDTO.setCode(500);
			responseDTO.setMessage("error :".concat(e.getMessage()));
		}
		return responseDTO;
		
	}
	
	
	
	
	
	
	
	

}
