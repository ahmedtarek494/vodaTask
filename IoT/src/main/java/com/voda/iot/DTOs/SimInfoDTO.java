package com.voda.iot.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SimInfoDTO {

	
	private Integer id;
	
	private String operatorId;
	
	private String country;
	
	private String status;
}
