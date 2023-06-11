package com.sdp.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sdp.hms.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
	
   Boolean existsByVehicleType(String vehicleType);
   
   List<Parking> findByVehicleType(String vehicleType);
	

}
