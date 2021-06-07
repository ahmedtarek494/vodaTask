package com.voda.iot.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeviceInfoDTO {

	
	private Integer id;
	
	private String color;
	
	private String status;
	
	private Integer temp;
	
	private String deleteEndpoint;
    
	private String updateEndpoint;
	
	private SimInfoDTO simInfo;
	
	public DeviceInfoDTO(int id,String color,String status,Integer temp,SimInfoDTO simInfo) {
		
		this.id=id;
		this.color=color;
		this.status=status;
		this.temp=temp;
		this.simInfo=simInfo;
		
	}
}
