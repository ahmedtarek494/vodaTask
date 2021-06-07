package com.voda.iot.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PagedRequestBody {
	
	private int pageNumber;
	private int limit;
	
	

}
