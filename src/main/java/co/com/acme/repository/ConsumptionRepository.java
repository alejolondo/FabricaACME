package co.com.acme.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.acme.model.Consumption;

public interface ConsumptionRepository extends CrudRepository<Consumption, Long> {
	

}
