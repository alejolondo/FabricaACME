package co.com.acme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.acme.dto.DeviceDTO;
import co.com.acme.model.Device;
import co.com.acme.service.DeviceService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/device")
@Slf4j
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService; 
	
	@GetMapping()
	public ResponseEntity<List<DeviceDTO>> getAllDevices(){
		List<DeviceDTO> devices = deviceService.getAllDevices();
		
		if(devices.isEmpty()) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(devices);
		}
		return ResponseEntity.status(HttpStatus.OK).body(devices);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DeviceDTO> getDeviceById(@PathVariable("id")long id){
		DeviceDTO device = deviceService.getDeviceById(id);
		 
		if(device.equals(null)) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(device);
		}
		return ResponseEntity.status(HttpStatus.OK).body(device);
	}


	@PostMapping
	public ResponseEntity<?> createDevice(@Valid @RequestBody DeviceDTO  device){
		deviceService.createDevice(device);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Device created sucessfull");
	}
	
}
