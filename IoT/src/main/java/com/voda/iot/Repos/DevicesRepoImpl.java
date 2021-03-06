package com.voda.iot.Repos;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.voda.iot.DTOs.DeviceInfoDTO;
import com.voda.iot.DTOs.SimInfoDTO;
import com.voda.iot.entities.Devices;


@Repository
public class DevicesRepoImpl extends BaseRepoImpl<Devices, Integer> implements DevicesRepo{

	public DevicesRepoImpl( EntityManager em) {
		super(Devices.class, em);
		// TODO Auto-generated constructor stub
	}

	public void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DeviceInfoDTO> devicesBySimStatus(String simStatus, int limit,int pageNumber) {

		return queryFactory.from(device).innerJoin(device.simId, sim).where(sim.status.equalsIgnoreCase(simStatus)).orderBy(new CaseBuilder().when(device.status.eq("READY"))
	            .then(1)
	            .otherwise(2).asc())
				.select(Projections.constructor(DeviceInfoDTO.class, device.id, device.color.trim(), device.status.trim(),
						device.temp,
						Projections.constructor(SimInfoDTO.class, sim.id, sim.operatorCode.trim(), sim.country.trim(), sim.status.trim()))).limit(limit).offset(pageNumber*limit).fetch();
	}

	@Override
	public long numberOfDevicesBysim(String simStatus) {
		// TODO Auto-generated method stub
	return queryFactory.from(device).innerJoin(device.simId, sim).where(sim.status.equalsIgnoreCase(simStatus)).fetchCount(); 	}

	@Override
	public void update(Devices dev) {

		queryFactory.update(device)
		  .where(device.id.eq(dev.getId()))
		  .set(device.status, dev.getStatus())
		  .set(device.temp, dev.getTemp())
		  .execute();
	
	}
	


	

	
}
