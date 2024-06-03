package co.com.acme.service;

import java.util.List;

import co.com.acme.dto.DeviceDTO;

public interface DeviceService {
	
	public List<DeviceDTO> getAllDevices();
	
	public DeviceDTO getDeviceById(Long id);

	public void createDevice(DeviceDTO device);
}
