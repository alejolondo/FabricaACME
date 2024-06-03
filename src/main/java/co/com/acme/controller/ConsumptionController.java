package co.com.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.acme.dto.ConsumptionDTO;
import co.com.acme.dto.ResponseDTO;
import co.com.acme.service.ConsumptionService;
import co.com.acme.service.DeviceService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/consumptions")
@Slf4j
public class ConsumptionController {

	@Autowired
	private ConsumptionService consumptionService;
	
	@Autowired
	private DeviceService deviceService;

	@PostMapping
	public ResponseEntity<ResponseDTO> createConsumption(@Valid @RequestBody ConsumptionDTO consumption) {
	    try {
	         consumptionService.createConsumption(consumption);
	        return ResponseEntity.ok().body(new ResponseDTO(200, "Consumption saved successfully")); 
	    } catch (IllegalArgumentException e) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(404, e.getMessage()));
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDTO(500, "Internal Server Error"));
	    }
	}


}
