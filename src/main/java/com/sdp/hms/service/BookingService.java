package com.sdp.hms.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.hms.dao.BookingRepository;
import com.sdp.hms.dao.GuestRepository;
import com.sdp.hms.dao.ParkingRepository;
import com.sdp.hms.dto.BookingDto;
import com.sdp.hms.dto.GuestsDto;
import com.sdp.hms.entity.Booking;
import com.sdp.hms.entity.Guests;
import com.sdp.hms.entity.Parking;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Service
public class BookingService {

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private ParkingRepository parkingRepository;

	@Autowired
	private BookingRepository bookingRepository;

	private final String checkInTime = "12:00:00";
	private final String checkOutTime = "12:00:00";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void bookRoom(BookingDto bookingDto) {
		Booking booking = new Booking();
		List<Guests> guests = saveGuests(bookingDto.getGuests());
		List<Parking> parking = parkingRepository.findByVehicleType(bookingDto.getParkingType());
		booking.setGuests(guests);
		booking.setArrivalDate(LocalDateTime.parse(bookingDto.getArrivalDate() + " " + checkInTime, formatter));
		booking.setDepartureDate(LocalDateTime.parse(bookingDto.getArrivalDate() + " " + checkOutTime, formatter));
		booking.setNumberOfGuests(bookingDto.getNumberOfGuests());
		booking.setAmount(0.0);
		booking.setParking(parking);
		booking.setPaymentType(bookingDto.getPaymentType());
		bookingRepository.save(booking);

	}

	public List<Guests> saveGuests(List<GuestsDto> guestsDto) {
		List<Guests> guests = new ArrayList<>();
		guestsDto.stream().forEach((guest) -> {
			guests.add(new Guests(guest.getName()));
		});
		return guestRepository.saveAll(guests);

	}

}
