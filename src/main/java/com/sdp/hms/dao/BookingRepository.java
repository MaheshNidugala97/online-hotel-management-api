package com.sdp.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sdp.hms.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

	Booking findByEmail(String email);

	@Query( value="SELECT b from Rooms r join Booking b on r.id=b.id where r.roomNo IN (:roomNumbers)")
	List<Booking> getArrivalAndDeptDate(List<Integer> roomNumbers);
	
	@Query( "SELECT b from  Booking b where b.email=?1")
	List<Booking> getBookingByEmail(String email);

}
