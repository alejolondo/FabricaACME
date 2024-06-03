package co.com.acme.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class Device {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="name field is required")
	@Size(min=2, max=30, message="name must be between 2 and 30 characters")
	private String name;
	
	
	@OneToMany(mappedBy = "device", fetch = FetchType.LAZY)
	private List<Consumption> consumption;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	

	public Device() {
		super();
	}
	
	

	public Device(Long id) {
		super();
		this.id = id;
	}



	public Device(Long id,
			@NotEmpty(message = "name field is required") @Size(min = 2, max = 30, message = "name must be between 2 and 30 characters") String name,
			List<Consumption> consumption, Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.consumption = consumption;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Consumption> getConsumption() {
		return consumption;
	}

	public void setConsumption(List<Consumption> consumption) {
		this.consumption = consumption;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate 
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", consumption=" + consumption + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	

}
