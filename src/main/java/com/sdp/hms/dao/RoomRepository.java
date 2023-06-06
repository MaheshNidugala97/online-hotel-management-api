package com.sdp.hms.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sdp.hms.entity.Rooms;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface RoomRepository extends JpaRepository<Rooms, Long> {
	
	Rooms findByRoomNoAndIsActive(Integer roomNo, Boolean isActive);
	
	List<Rooms> findByIsActive(Boolean isActive);
	
	Boolean existsByRoomNo(Integer roomNo);
	
	@Query("SELECT r,c from Rooms r join RoomCategory c on r.category=c.id where c.title=?1 and r.isActive=?2")
	List<Rooms> findByCategory(String title, Boolean isActive);
}
