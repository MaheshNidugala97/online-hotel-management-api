package com.sdp.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sdp.hms.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
	
   Boolean existsByVehicleType(String vehicleType);
   
   Parking findByVehicleType(String vehicleType);
	

}
