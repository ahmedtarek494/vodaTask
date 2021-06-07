package com.voda.iot.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DevicesResponse {

	private long totalCount;
	
	private List<DeviceInfoDTO> devices;
}
