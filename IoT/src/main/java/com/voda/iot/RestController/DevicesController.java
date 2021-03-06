package com.voda.iot.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voda.iot.DTOs.DevicesResponse;
import com.voda.iot.DTOs.PagedRequestBody;
import com.voda.iot.DTOs.UpdateStatusRequest;
import com.voda.iot.Services.DevicesService;
import com.voda.iot.utilities.SimStatusConstant;

@RestController
@RequestMapping("/devices")
public class DevicesController {
	
	@Autowired
	DevicesService deviceService;
	
	@PostMapping(path = "/getWaitingForActivationDevices", produces = "application/json")
	public DevicesResponse getWaitingForActivationDevices(@RequestBody PagedRequestBody request){
		return deviceService.getDevicesBySimStatus(SimStatusConstant.WAITING_FOR_ACTIVATION,request.getLimit(),request.getPageNumber());
		
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable(value="id") int id){
		
		 deviceService.deleteById(id);
		 return  new ResponseEntity<String>("Device removed", HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable(value="id") int id,@RequestBody UpdateStatusRequest request){
		
		 deviceService.updateById(id, request.getStatus(), request.getTemp());
		 return  new ResponseEntity<String>("Device updated", HttpStatus.OK);
	}
}
