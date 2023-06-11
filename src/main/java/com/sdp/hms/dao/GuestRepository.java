package com.sdp.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sdp.hms.entity.Guests;

/**
 * 
 * @author mahesh nidugala
 *
 */

public interface GuestRepository extends JpaRepository<Guests, Long> {

}
