package co.com.acme.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.acme.model.Consumption;

@Repository
public interface ConsumptionRepository extends CrudRepository<Consumption, Long> {
	
	List<Consumption> findByDeviceIdAndConsumptionDateBetween(Long deviceId, LocalDate startDate, LocalDate endDate);
}
