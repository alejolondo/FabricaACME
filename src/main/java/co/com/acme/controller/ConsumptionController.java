package co.com.acme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.acme.dto.ResponseDTO;
import co.com.acme.model.Consumption;
import co.com.acme.service.ConsumptionService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/consumptions")
@Slf4j
public class ConsumptionController {

	@Autowired
	private ConsumptionService consumptionService;

	@PostMapping
	public ResponseEntity<ResponseDTO> createConsumption(@Valid @RequestBody Consumption consumption) {
		return ResponseEntity.ok().body(consumptionService.createConsumption(consumption));
		
	}
}
