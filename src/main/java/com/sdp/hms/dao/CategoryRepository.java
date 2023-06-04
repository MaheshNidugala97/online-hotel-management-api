package com.sdp.hms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sdp.hms.entity.RoomCategory;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface CategoryRepository  extends JpaRepository<RoomCategory, Long>{
	
//	@Query("SELECT * from room_category u where u.title=?1")
	
	
	Boolean existsByTitle(String title);
	
	Boolean existsBySize(Long size);
	
	

}
