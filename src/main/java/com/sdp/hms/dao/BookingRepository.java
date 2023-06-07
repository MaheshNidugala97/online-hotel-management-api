package com.sdp.hms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdp.hms.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
