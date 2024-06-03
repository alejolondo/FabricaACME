package co.com.acme.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class Consumption {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id") 
    private Device device;
    
    @NotNull(message = "Consumption date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate consumptionDate;
    
    @NotNull(message = "Consumption value is required")
    @Min(value = 0, message = "Consumption value must be positive")    
    private Double consumptionValue;
    
    @Column(updatable = false)
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

    public Consumption() {
        super();
    }

    public Consumption(Long id, Device device,
            @NotNull(message = "Consumption date is required") LocalDate consumptionDate,
            @NotNull(message = "Consumption value is required") @Min(value = 0, message = "Consumption value must be positive") Double consumptionValue,
            LocalDateTime createdAt, LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.device = device;
        this.consumptionDate = consumptionDate;
        this.consumptionValue = consumptionValue;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

	@Override
	public String toString() {
		return "Consumption [id=" + id + ", device=" + device + ", consumptionDate=" + consumptionDate
				+ ", consumptionValue=" + consumptionValue + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}
    
    
}
