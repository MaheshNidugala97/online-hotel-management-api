package com.sdp.hms.service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.sdp.hms.dao.ParkingRepository;
import com.sdp.hms.dto.ParkingDto;
import com.sdp.hms.entity.Parking;
import com.sdp.hms.entity.RoomCategory;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Service
public class ParkingService {
	
	@Autowired
	private ParkingRepository parkingRepository;

	public void addParking(ParkingDto parkingDto) {
		Parking parking = new Parking();
		parking.setVehicleType(parkingDto.getVehicleType());
		parking.setPrice(parkingDto.getPrice());
		parkingRepository.save(parking);
		
		
	}

	public void updateParking(Parking parking, ParkingDto parkingDto) {
		parking.setVehicleType(parkingDto.getVehicleType());
		parking.setPrice(parkingDto.getPrice());
		parkingRepository.save(parking);
		
	}

	public Parking updateSpecificParking(Parking parking, Optional<Map<String, Object>> fields) {
		if (parking != null) {
			fields.get().forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Parking.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, parking, value);
			});
			return parkingRepository.save(parking);
		}
		return null;
	}

}
