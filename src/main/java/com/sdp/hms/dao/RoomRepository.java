package com.sdp.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sdp.hms.entity.Rooms;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface RoomRepository extends JpaRepository<Rooms, Long> {
	
	Rooms findByRoomNo(Integer roomNo);
	
	Boolean existsByRoomNo(Integer roomNo);

}
