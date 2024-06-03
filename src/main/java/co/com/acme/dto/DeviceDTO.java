package co.com.acme.dto;

import lombok.Data;

@Data

public class DeviceDTO {

	
	private Long id;
	
	private String name;

	public DeviceDTO() {
	}

	

	public DeviceDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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



	@Override
	public String toString() {
		return "DeviceDTO [id=" + id + ", name=" + name + "]";
	}



	
	
	

}
