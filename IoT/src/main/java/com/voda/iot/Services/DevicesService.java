package com.voda.iot.Services;

import com.voda.iot.DTOs.DevicesResponse;


public interface DevicesService {
	
	public DevicesResponse getDevicesBySimStatus(String simStatus,int limit,int page) ;
 

	public void deleteById(int id);
	
	public void updateById(int id,String status,int temp);
}
