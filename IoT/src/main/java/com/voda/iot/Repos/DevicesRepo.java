package com.voda.iot.Repos;


import java.util.List;

import com.voda.iot.DTOs.DeviceInfoDTO;
//import com.voda.iot.DTOs.DeviceInfoDto;
import com.voda.iot.entities.Devices;



public interface DevicesRepo extends BaseRepo<Devices, Integer>{
	
	public List<DeviceInfoDTO> devicesBySimStatus(String simStatus , int limit,int pageNumber);
	
	public long numberOfDevicesBysim(String simStatus );
	
	public void update (Devices dev);

}
