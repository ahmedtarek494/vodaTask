package com.voda.iot.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Devices implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String color;
	
	
	private String status;
	
	private Integer temp;
	
	@OneToOne(mappedBy = "device_id", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
	private SIM simId;
}
