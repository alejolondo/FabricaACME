package co.com.acme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.acme.model.Device;

@Repository
public interface DeviceRepository  extends CrudRepository<Device, Long>{
	
	
	

}
