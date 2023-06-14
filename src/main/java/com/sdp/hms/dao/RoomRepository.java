package com.sdp.hms.dao;

import java.time.LocalDateTime;
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
	List<Rooms> findByAllRoomNo(List<Integer> roomNumbers, Boolean isActive);

	@Query("SELECT r from Rooms r where r.roomNo IN (:roomNumbers)")
	List<Rooms> findByRoomNumbers(List<Integer> roomNumbers);

	@Modifying
	@Query("UPDATE Rooms r SET r.isActive=false where r.roomNo IN (:roomNumbers)")
	public void updateRoomsToInactive(List<Integer> roomNumbers);

	@Modifying
	@Query("UPDATE Rooms r SET r.isActive=true where r.roomNo IN (:roomNumbers)")
	public void updateRoomsToActive(List<Integer> roomNumbers);

	@Query(value = "SELECT * from rooms r where r.booking_id=?1", nativeQuery = true)
	List<Rooms> findByBookingId(Long id);

	@Query(value = "SELECT count(r.room_no) from rooms r where r.category=?1 and r.active=true ", nativeQuery = true)
	Integer findRoomCount(Long id);

	@Modifying
	@Query("UPDATE Rooms r SET r.arrivalDate=:arrivalDate, r.deptDate=:deptDate where r.roomNo IN (:roomNumbers)")
	void updateRoomDates(LocalDateTime arrivalDate, LocalDateTime deptDate, List<Integer> roomNumbers);

	@Query("SELECT r from Rooms r where (r.arrivalDate>?2 or r.deptDate<?1 or r.arrivalDate is null or r.deptDate is null) and r.isActive=true")
	List<Rooms> findByDates(LocalDateTime arrivalDateOfNewCustomer, LocalDateTime deptDateOfNewCustomer);

	@Query(value = "SELECT count(r.room_no) from rooms r where (r.category=?1 and r.active=true) and (r.arrival_date>?3 or r.departure_date<?2 or r.arrival_date is null or r.departure_date is null) ", nativeQuery = true)
	Integer findRoomCountByDates(Long id, LocalDateTime arrivalDateOfNewCustomer, LocalDateTime deptDateOfNewCustomer);
	
}
