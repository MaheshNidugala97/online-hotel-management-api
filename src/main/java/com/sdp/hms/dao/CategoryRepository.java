package com.sdp.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sdp.hms.entity.RoomCategory;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface CategoryRepository extends JpaRepository<RoomCategory, Long> {

	@Query("SELECT u from RoomCategory  u where u.title=?1")
	RoomCategory findByTitle(String title);

	Boolean existsByTitle(String title);

	Boolean existsBySize(Double size);
	
	@Query("SELECT c.maxPeopleAllowed from RoomCategory c where c.id=?1")
	public Integer getMaxPeopleAllowed(Long id);

}
