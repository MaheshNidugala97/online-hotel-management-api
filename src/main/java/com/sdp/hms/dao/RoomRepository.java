package com.sdp.hms.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.sdp.hms.entity.Rooms;
import jakarta.transaction.Transactional;

/**
 * 
 * @author mahesh nidugala
 *
 */


@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Rooms, Long> {
	
	List<Rooms> findByRoomNoAndIsActive(Integer roomNo, Boolean isActive);
	
	List<Rooms> findByIsActive(Boolean isActive);
	
	Boolean existsByRoomNo(Integer roomNo);
	
	@Query("SELECT r,c from Rooms r join RoomCategory c on r.category=c.id where c.title=?1 and r.isActive=?2")
	List<Rooms> findByCategory(String title, Boolean isActive);
	
	@Query("SELECT r from Rooms r where r.roomNo IN (:roomNumbers) and r.isActive=:isActive")
	List<Rooms> findByAllRoomNo( List<Integer> roomNumbers, Boolean isActive);
	
	@Query("SELECT r from Rooms r where r.roomNo IN (:roomNumbers)")
	List<Rooms> findByRoomNumbers( List<Integer> roomNumbers);
	
	@Modifying
	@Query("UPDATE Rooms r SET r.isActive=false where r.roomNo IN (:roomNumbers)")
	public void updateRoomsToInactive(List<Integer> roomNumbers);
	
}
