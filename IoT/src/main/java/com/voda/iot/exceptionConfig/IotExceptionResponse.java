package com.voda.iot.exceptionConfig;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IotExceptionResponse {

	
	private Date timestamp;
	private String message;
	private String Code;
	private String details;
}
