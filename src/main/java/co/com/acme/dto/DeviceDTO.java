package co.com.acme.dto;

import lombok.Data;

@Data

public class DeviceDTO {

	
	
	private String name;

	public DeviceDTO() {
	}

	public DeviceDTO(String name) {
		super();
		this.name = name;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DeviceDTO [name=" + name + "]";
	}
	
	
	
	

}
