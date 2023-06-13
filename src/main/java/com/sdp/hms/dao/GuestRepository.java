package com.sdp.hms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sdp.hms.entity.Guests;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface GuestRepository extends JpaRepository<Guests, Long> {

	@Query(value="SELECT * from guests g where g.booking_id=?1", nativeQuery = true)
	List<Guests> findByBookingId(Long id);

}
