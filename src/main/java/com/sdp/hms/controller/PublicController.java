package com.sdp.hms.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sdp.hms.dao.BookingRepository;
import com.sdp.hms.dao.CategoryRepository;
import com.sdp.hms.dao.GuestRepository;
import com.sdp.hms.dao.ParkingRepository;
import com.sdp.hms.dao.RoomRepository;
import com.sdp.hms.dto.BookingDto;
import com.sdp.hms.dto.EmailDto;
import com.sdp.hms.entity.Booking;
import com.sdp.hms.entity.Parking;
import com.sdp.hms.entity.RoomCategory;
import com.sdp.hms.entity.Rooms;
import com.sdp.hms.exception.ApiRequestException;
import com.sdp.hms.exception.InternalServerException;
import com.sdp.hms.exception.NotFoundException;
import com.sdp.hms.service.BookingService;
import com.sdp.hms.service.RoomService;

/**
 * 
 * @author mahesh nidugala
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hms")
public class PublicController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ParkingRepository parkingRepository;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private BookingRepository bookingRepository;

	private final String checkInTime = "12:00:00";
	private final String checkOutTime = "12:00:00";
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@GetMapping("category")
	public List<RoomCategory> getAllCategory() {
		try {
			return categoryRepository.findAll();
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage());

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("category/title/{title}")
	public RoomCategory getCategoryByTitle(@PathVariable String title) {
		try {
			return categoryRepository.findByTitle(title);
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for category with title " + title);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("category/id/{id}")
	public RoomCategory getCategoryById(@PathVariable Long id) {
		try {
			return categoryRepository.findById(id).get();
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("rooms")
	public List<Rooms> getAllRooms(@RequestParam Optional<Boolean> isActive) {
		try {
			if (isActive.isPresent()) {

				return roomRepository.findByIsActive(isActive.get());
			} else {
				return roomRepository.findAll();
			}
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage());

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("rooms/available")
	public List<Rooms> getAllRoomsByDate(@RequestParam String arrivalDate, @RequestParam String deptDate) {
		try {
			LocalDateTime deptDateOfNewCustomer = LocalDateTime.parse(deptDate + " " + checkInTime, formatter);
			LocalDateTime arrivalDateOfNewCustomer = LocalDateTime.parse(arrivalDate + " " + checkOutTime, formatter);
			return roomRepository.findByDates(arrivalDateOfNewCustomer, deptDateOfNewCustomer);
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage());

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("room")
	public List<Rooms> getRoomByNumbers(@RequestParam String roomNumbers, @RequestParam Boolean isActive) {
		try {

			List<Integer> listRoomNumbers = new ArrayList<>();
			String[] arrayRoomNumbers = roomNumbers.split(",");
			for (String roomNumber : arrayRoomNumbers) {
				Integer roomNo = Integer.parseInt(roomNumber);
				listRoomNumbers.add(roomNo);
			}
			return roomRepository.findByAllRoomNo(listRoomNumbers, isActive);
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for room number " + roomNumbers);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("room/id/{id}")
	public Rooms getRoomById(@PathVariable Long id) {
		try {
			return roomRepository.findById(id).get();
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for room with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("rooms/category/title/{title}")
	public List<Rooms> getRoomsByCategory(@RequestParam(defaultValue = "true") Boolean isActive,
			@PathVariable String title) {
		try {
			List<Rooms> listOfRooms = roomRepository.findByCategory(title, isActive);
			if (listOfRooms.isEmpty()) {
				throw new NotFoundException("Rooms not found for category " + title);
			}
			return listOfRooms;

		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage());

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("parking")
	public List<Parking> getAllParking() {
		try {
			List<Parking> listOfParking = parkingRepository.findAll();
			if (listOfParking.isEmpty()) {
				throw new NotFoundException("Parkings not found");
			}
			return listOfParking;
		} catch (NotFoundException e) {
			throw new NotFoundException(e.getMessage());

		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage());

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping("parking/vehicletype/{vehicletype}")
	public List<Parking> getParkingByType(@PathVariable String vehicletype) {
		try {
			List<Parking> parking = parkingRepository.findByVehicleType(vehicletype);
			if (parking.isEmpty()) {
				throw new NotFoundException("Parking with vehicle type " + vehicletype + " not found");
			}
			return parking;
		} catch (NotFoundException e) {
			throw new NotFoundException(e.getMessage());

		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for vehicel with type " + vehicletype);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PostMapping(value = "booking/book")
	public ResponseEntity<?> bookRoom(@RequestBody BookingDto bookingDto, @RequestParam String roomNumbers) {
		try {
			bookingService.bookRoom(bookingDto, roomNumbers);
			return ResponseEntity.status(HttpStatus.OK).body("You have successfully booked rooms " + roomNumbers
					+ " for date " + bookingDto.getArrivalDate() + " to " + bookingDto.getDepartureDate());
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	@PostMapping("user/bookings")
	public List<Booking> getBookingsByEmail(@RequestBody EmailDto emailDto) {
		try {
			return bookingRepository.getBookingByEmail(emailDto.getEmail());
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for room with email id " + (emailDto.getEmail()));

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@GetMapping(value = "room/estimated/price")
	public Map<String, Double> getEstimatedPrice(@RequestParam String roomNumbers, @RequestParam String arrivalDate,
			@RequestParam String deptDate, @RequestParam Boolean isActive) {
		try {
			double estimatedRoomPrice = roomService.getEstimatedPrice(roomNumbers, arrivalDate, deptDate, isActive);
			return Collections.singletonMap("estimatedPrice", estimatedRoomPrice);
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	@GetMapping(value = "room/count")
	public Map<String, Integer> getRoomCount(@RequestParam Long categoryId, @RequestParam Optional<Boolean> isActive) {
		try {
			Integer roomCount = roomRepository.findRoomCount(categoryId, isActive.get());
			return Collections.singletonMap("totalRoomCount", roomCount);
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

	@GetMapping(value = "max/guests/category/id/{id}")
	public Map<String, Integer> getMaxGuests( @PathVariable Long id,
			@RequestParam Optional<Boolean> isActive) {
		try {
			Integer roomCount = roomRepository.findRoomCount(id, isActive.get());
			Integer maxPeopleAllowedInRoom= categoryRepository.getMaxPeopleAllowed(id);
			Integer maxGuestAllowed= roomCount*maxPeopleAllowedInRoom;
			return Collections.singletonMap("maxGuestAllowed", maxGuestAllowed);
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException(e.getMessage());
		}

	}

}
