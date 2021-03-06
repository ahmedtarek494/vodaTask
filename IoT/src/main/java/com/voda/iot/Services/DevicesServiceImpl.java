package com.voda.iot.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voda.iot.DTOs.DeviceInfoDTO;
import com.voda.iot.DTOs.DevicesResponse;
import com.voda.iot.Repos.DevicesRepo;
import com.voda.iot.entities.Devices;
import com.voda.iot.utilities.SimStatusConstant;

@Service
public class DevicesServiceImpl implements DevicesService {

	@Autowired
	DevicesRepo devicesRepo;

	@Override
	public DevicesResponse getDevicesBySimStatus(String simStatus, int limit, int page) {
		// TODO Auto-generated method stub
		DevicesResponse devicesResponse = new DevicesResponse();
		try {

			devicesResponse.setTotalCount(devicesRepo.numberOfDevicesBysim(simStatus));
			List<DeviceInfoDTO> devices = devicesRepo.devicesBySimStatus(simStatus, limit, page);
			devices.forEach(device -> {
				device.setDeleteEndpoint(SimStatusConstant.DELETE_ENDPOINT.concat(String.valueOf(device.getId())));
				device.setUpdateEndpoint(SimStatusConstant.UPDATE_ENDPOINT.concat(String.valueOf(device.getId())));

			}

			);
			devicesResponse.setDevices(devices);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return devicesResponse;
	}

	@Override
	public void deleteById(int id) {

		try {
			devicesRepo.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void updateById(int id, String status, int temp) {
		// TODO Auto-generated method stub
		
		Devices dev = new Devices();

		try {
		dev.setId(id);
		dev.setStatus(status);
		dev.setTemp(temp);
		devicesRepo.update(dev);
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
