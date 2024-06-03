package co.com.acme.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.acme.model.Device;

public interface DeviceRepository  extends CrudRepository<Device, Long>{

}
