package co.com.acme.dto;

import java.time.LocalDate;

import co.com.acme.model.Device;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsumptionDTO {

	
	
	
	@NotNull(message = "You must enter a device id")
	private Device device;
	
	@NotNull(message = "Consumption date is required")
	private LocalDate consumptionDate;

	@NotNull(message = "Consumption value is required")
    @Min(value = 0, message = "Consumption value must be positive")
	private Double consumptionValue;

	
	public ConsumptionDTO() {
	}

	

	public ConsumptionDTO( Device device, LocalDate consumptionDate, Double consumptionValue) {
		super();
		
		this.device = device;
		this.consumptionDate = consumptionDate;
		this.consumptionValue = consumptionValue;
	}

	
	
	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}


	public LocalDate getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(LocalDate consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public Double getConsumptionValue() {
		return consumptionValue;
	}

	public void setConsumptionValue(Double consumptionValue) {
		this.consumptionValue = consumptionValue;
	}

	

	
	
	
	
}
