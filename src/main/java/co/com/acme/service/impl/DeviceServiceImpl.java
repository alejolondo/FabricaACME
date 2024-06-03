package co.com.acme.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.acme.dto.DeviceDTO;
import co.com.acme.mapper.DeviceMapper;
import co.com.acme.model.Device;
import co.com.acme.repository.DeviceRepository;
import co.com.acme.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private DeviceMapper deviceMapper;
	
	@Override
	public List<DeviceDTO> getAllDevices() {
		List<Device> devices =  (List<Device>) deviceRepository.findAll();
		return deviceMapper.listDeviceToListDeviceDTO(devices);
	}

	@Override
	public DeviceDTO getDeviceById(Long id) {
		Device device = deviceRepository.findById(id).orElse(null);
		return deviceMapper.deviceToDeviceDTO(device);
	}
	
	@Override
	public void createDevice(DeviceDTO device) {
		deviceRepository.save(deviceMapper.deviceDTOToDevice(device));
		
	}

	

}
