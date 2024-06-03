package co.com.acme.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ConsumptionDTO {

	
	private Long idDevice;
	
	private LocalDateTime consumptionDate;

	private Double consumptionValue;

	public Long getIdDevice() {
		return idDevice;
	}

	public ConsumptionDTO() {
	}

	public ConsumptionDTO(Long idDevice, LocalDateTime consumptionDate, Double consumptionValue) {
		super();
		this.idDevice = idDevice;
		this.consumptionDate = consumptionDate;
		this.consumptionValue = consumptionValue;
	}



	public void setIdDevice(Long idDevice) {
		this.idDevice = idDevice;
	}

	public LocalDateTime getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(LocalDateTime consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public Double getConsumptionValue() {
		return consumptionValue;
	}

	public void setConsumptionValue(Double consumptionValue) {
		this.consumptionValue = consumptionValue;
	}
	
	
	
}
