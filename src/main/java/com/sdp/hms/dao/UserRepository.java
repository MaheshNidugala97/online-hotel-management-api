package com.sdp.hms.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp.hms.entity.User;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {

 
	Optional<User>  findByEmail(String email);
	
	Optional<User>  findByUsername(String username);
	
	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

}