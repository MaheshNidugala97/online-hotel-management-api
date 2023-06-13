package com.sdp.hms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sdp.hms.entity.Parking;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface ParkingRepository extends JpaRepository<Parking, Long> {

	Boolean existsByVehicleType(String vehicleType);

	List<Parking> findByVehicleType(String vehicleType);

	@Query("SELECT p from Parking p where p.vehicleType IN (:vehicleTypes)")
	List<Parking> findByListOfVehicleType(List<String> vehicleTypes);

	@Query("SELECT p.price from Parking p where p.vehicleType=?1")
	double getVehicleCost(String vehicleType);


}
