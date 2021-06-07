package com.voda.iot.exceptionConfig;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class IotRestExceptionHandler extends ResponseEntityExceptionHandler {




	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public IotExceptionResponse handleAllException(Exception ex, WebRequest request) throws Exception {
		log.error("" + ex);
		ex.printStackTrace();
		System.out.println("----Exception----");
		return new IotExceptionResponse(new Date(), "Internal Exception", null,"500");

	}
}
