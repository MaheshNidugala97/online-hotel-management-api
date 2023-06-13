package com.sdp.hms.service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.sdp.hms.dao.BookingRepository;
import com.sdp.hms.dao.GuestRepository;
import com.sdp.hms.dao.ParkingRepository;
import com.sdp.hms.dao.RoomRepository;
import com.sdp.hms.dto.BookingDto;
import com.sdp.hms.dto.GuestsDto;
import com.sdp.hms.dto.NumberOfParkingDto;
import com.sdp.hms.entity.Booking;
import com.sdp.hms.entity.Guests;
import com.sdp.hms.entity.Parking;
import com.sdp.hms.entity.Rooms;

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

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private RoomService roomService;

	private final String checkInTime = "12:00:00";
	private final String checkOutTime = "12:00:00";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void bookRoom(BookingDto bookingDto, String roomNumbers) {
		try {
			double finalPrice = Double.valueOf((String) bookingDto.getTotalCost());
			double parkingPrice = 0.0;
			Booking booking = new Booking();
			List<Guests> guests = saveGuests(bookingDto.getGuests());
			List<Integer> listRoomNumbers = new ArrayList<>();
			String[] arrayRoomNumbers = roomNumbers.split(",");
			for (String roomNumber : arrayRoomNumbers) {
				Integer roomNo = Integer.parseInt(roomNumber);
				listRoomNumbers.add(roomNo);
			}
			List<Rooms> rooms = roomRepository.findByRoomNumbers(listRoomNumbers);
			List<String> listOfParkings = new ArrayList<>();
			if (bookingDto.getParkingList().isPresent()) {
				for (NumberOfParkingDto aa : bookingDto.getParkingList().get()) {
					double vehicleCost = parkingRepository.getVehicleCost(aa.getVehicleType());
					Integer no = aa.getNumberOfVehicles();
					parkingPrice = parkingPrice + vehicleCost * no;
					listOfParkings.add(aa.getVehicleType());
				}
				List<Parking> parking = parkingRepository.findByListOfVehicleType(listOfParkings);
				long numberOfDays = roomService.calculateDays(bookingDto.getArrivalDate(),
						bookingDto.getDepartureDate());
				finalPrice = finalPrice + parkingPrice * numberOfDays;
				booking.setParking(parking);
			} else {
				booking.setParking(null);
			}
			booking.setEmail(bookingDto.getEmail());
			booking.setGuests(guests);
			booking.setRooms(rooms);
			booking.setArrivalDate(LocalDateTime.parse(bookingDto.getArrivalDate() + " " + checkInTime, formatter));
			booking.setDepartureDate(LocalDateTime.parse(bookingDto.getArrivalDate() + " " + checkOutTime, formatter));
			booking.setNumberOfGuests(bookingDto.getNumberOfGuests());
			booking.setTotalCost(finalPrice);
			booking.setPaymentType(bookingDto.getPaymentType());
			bookingRepository.save(booking);
			roomRepository.updateRoomsToInactive(listRoomNumbers);

		} catch (Exception e) {
			throw e;
		}
	}

	public List<Guests> saveGuests(List<GuestsDto> guestsDto) {
		List<Guests> guests = new ArrayList<>();
		guestsDto.stream().forEach((guest) -> {
			guests.add(new Guests(guest.getName()));
		});
		return guestRepository.saveAll(guests);

	}

	public Booking updateSpecificBookings(Booking booking, Optional<Map<Object, Object>> fields) {
		if (booking != null) {
			fields.get().forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Booking.class, (String) key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, booking, value);
				
			});
			return bookingRepository.save(booking);
		}
		return null;
	}

	public void updateSpecificGuests(List<Guests> guest, Optional<Map<Object, Object>> fields) {
		if (guest != null) {
			fields.get().forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Guests.class, (String) key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, guest, value);
				
			});
			 guestRepository.saveAll(guest);
		}
		
	}

}
