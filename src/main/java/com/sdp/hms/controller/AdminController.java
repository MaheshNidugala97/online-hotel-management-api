package com.sdp.hms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdp.hms.dao.BookingRepository;
import com.sdp.hms.dao.CategoryRepository;
import com.sdp.hms.dao.GuestRepository;
import com.sdp.hms.dao.ParkingRepository;
import com.sdp.hms.dao.RoomRepository;
import com.sdp.hms.dao.TransactionRepository;
import com.sdp.hms.dto.BookingUpdateDto;
import com.sdp.hms.dto.CategoryDto;
import com.sdp.hms.dto.CheckoutDto;
import com.sdp.hms.dto.NumberOfParkingDto;
import com.sdp.hms.dto.ParkingDto;
import com.sdp.hms.dto.RoomDto;
import com.sdp.hms.entity.Booking;
import com.sdp.hms.entity.Parking;
import com.sdp.hms.entity.RoomCategory;
import com.sdp.hms.entity.Rooms;
import com.sdp.hms.entity.Transaction;
import com.sdp.hms.exception.ApiRequestException;
import com.sdp.hms.exception.InternalServerException;
import com.sdp.hms.exception.NotFoundException;
import com.sdp.hms.service.BookingService;
import com.sdp.hms.service.CategoryService;
import com.sdp.hms.service.ParkingService;
import com.sdp.hms.service.RoomService;
import com.sdp.hms.service.TransactionService;

/**
 * 
 * @author mahesh nidugala
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hms/admin")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RoomService roomService;

	@Autowired
	private ParkingService parkingService;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private ParkingRepository parkingRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TransactionRepository transactionRepository;

	ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping(value = "category/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addCategory(@RequestPart("categoryDto") CategoryDto categoryDto,
			@RequestPart("image") MultipartFile file) {
		try {
			if (categoryRepository.existsByTitle(categoryDto.getTitle())) {
				throw new ApiRequestException("Category with  " + categoryDto.getTitle() + " " + categoryDto.getSize()
						+ " mts sqr already Exists");
			}
			categoryService.addCategory(categoryDto, file);
//			Base64.getEncoder().encodeToString();
			return ResponseEntity.status(HttpStatus.OK).body(categoryDto.getTitle() + " successfully added");
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@DeleteMapping("category/delete/id/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		try {
			categoryRepository.findById(id).get();
			categoryRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " successfully deleted");
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}
	}

	@PutMapping(value = "category/update/id/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestPart("categoryDto") CategoryDto categoryDto,
			@RequestPart("image") MultipartFile file) {
		try {
			RoomCategory roomCategory = categoryRepository.findById(id).get();
			roomCategory.setImageData(new byte[0]);
			categoryService.updateCategory(roomCategory, categoryDto, file);
			return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " successfully updated");
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PatchMapping(value = "category/update/id/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public RoomCategory updateSpecificCategory(@PathVariable Long id,
			@RequestPart(value = "categoryDto") Optional<Map<String, Object>> fields,
			@RequestPart("image") Optional<MultipartFile> file) {
		try {
			RoomCategory roomCategory = categoryRepository.findById(id).get();
			if (file.isPresent()) {
				roomCategory.setImageData(new byte[0]);
				fields.get().put("imageData", file.get().getBytes());
			}
			return categoryService.updateSpecificCategory(roomCategory, fields);
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PostMapping(value = "room/add/category/id/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> addRoom(@RequestPart("roomDto") RoomDto roomdto, @PathVariable Long id,
			@RequestPart("image") MultipartFile file) throws IOException {
		try {
			RoomCategory roomCategory = categoryRepository.findById(id).get();
			if (roomRepository.existsByRoomNo(roomdto.getRoomNo())) {
				throw new ApiRequestException("Room with " + roomdto.getRoomNo() + " already Exists");
			}
			roomService.addRoom(roomdto, roomCategory, file);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Room number " + roomdto.getRoomNo() + " successfully added");
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@DeleteMapping("room/delete/id/{id}")
	public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
		try {
			roomRepository.findById(id).get();
			roomRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Room with id " + id + " successfully deleted");
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for room with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}
	}

	@PutMapping(value = "room/update/id/{id}/category/id/{categoryId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<?> updateRoom(@RequestPart("roomDto") RoomDto roomdto, @PathVariable Long id,
			@PathVariable Long categoryId, @RequestPart("image") MultipartFile file) throws IOException {
		Rooms rooms = null;
		RoomCategory roomCategory = null;
		try {
			rooms = roomRepository.findById(id).get();
			rooms.setImageData(new byte[0]);
			roomCategory = categoryRepository.findById(categoryId).get();
			roomService.updateRoom(rooms, roomdto, roomCategory, file);
			return ResponseEntity.status(HttpStatus.OK).body("Room with id " + id + " successfully updated");
		} catch (Exception e) {
			if (e.getMessage() == "No value present" && rooms == null) {
				throw new NotFoundException(e.getMessage() + " for room with id " + id);

			} else if (e.getMessage() == "No value present" && roomCategory == null) {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PatchMapping(value = "room/update/id/{id}/category", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Rooms updateSpecificRoom(
			@RequestPart(value = "roomDto", required = false) Optional<Map<String, Object>> fields,
			@PathVariable Long id, @RequestParam Optional<Long> categoryId,
			@RequestPart("image") Optional<MultipartFile> file) throws IOException {
		Rooms rooms = null;
		RoomCategory roomCategory = null;

		try {
			rooms = roomRepository.findById(id).get();
			if (categoryId.isPresent()) {
				roomCategory = categoryRepository.findById(categoryId.get()).get();
				fields.get().put("category", roomCategory);
			}
			if (file.isPresent()) {
				rooms.setImageData(new byte[0]);
				fields.get().put("imageData", file.get().getBytes());
			}
			return roomService.updateSpecificRooms(rooms, fields);

		} catch (Exception e) {
			if (e.getMessage() == "No value present" && rooms == null) {
				throw new NotFoundException(e.getMessage() + " for room with id " + id);

			} else if (e.getMessage() == "No value present" && roomCategory == null) {
				throw new NotFoundException(e.getMessage() + " for category with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PostMapping(value = "parking/add")
	public ResponseEntity<?> addParking(@RequestBody ParkingDto parkingDto) {
		try {
			if (parkingRepository.existsByVehicleType(parkingDto.getVehicleType())) {
				throw new ApiRequestException(
						"Parking with vehicle type  " + parkingDto.getVehicleType() + "already Exists");
			}
			parkingService.addParking(parkingDto);
			return ResponseEntity.status(HttpStatus.OK).body(parkingDto.getVehicleType() + " successfully added");
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@DeleteMapping("parking/delete/id/{id}")
	public ResponseEntity<?> deleteParking(@PathVariable Long id) {
		try {
			parkingRepository.findById(id).get();
			parkingRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Parking with id " + id + " successfully deleted");
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for parking with id " + id);

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}
	}

	@PutMapping(value = "parking/update/id/{id}")
	public ResponseEntity<?> updateRoom(@PathVariable Long id, @RequestBody ParkingDto parkingDto) {
		Parking parking = null;
		try {
			parking = parkingRepository.findById(id).get();
			parkingService.updateParking(parking, parkingDto);
			return ResponseEntity.status(HttpStatus.OK).body("Parking with id " + id + " successfully updated");
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for parking with id " + id);
			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PatchMapping(value = "parking/update/id/{id}")
	public Parking updateSpecificParking(@PathVariable Long id, @RequestBody Optional<Map<String, Object>> fields) {
		try {
			Parking parking = parkingRepository.findById(id).get();
			return parkingService.updateSpecificParking(parking, fields);
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for parking with id " + id);

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

	@GetMapping("bookings")
	public List<Booking> getCategoryById() {
		try {
			return bookingRepository.findAll();
		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException("No bookings found");

			} else {
				throw new InternalServerException(e.getMessage());
			}
		}

	}

	@PatchMapping(value = "bookings/update/id/{id}")
	public Booking updateBookings(@PathVariable Long id, @RequestParam String roomNumbers,
			@RequestBody BookingUpdateDto bookingUpdateDto) {
		try {
			Booking booking = bookingRepository.findById(id).get();
			double finalPrice = 0.0;
			double roomPrice = roomService.getEstimatedPrice(roomNumbers, bookingUpdateDto.getArrivalDate(),
					bookingUpdateDto.getDepartureDate(), false);
			double parkingPrice = 0.0;
			List<String> listOfParkings = new ArrayList<>();
			long numberOfDays = roomService.calculateDays(bookingUpdateDto.getArrivalDate(),
					bookingUpdateDto.getDepartureDate());
			for (NumberOfParkingDto aa : bookingUpdateDto.getParkingList().get()) {
				double vehicleCost = parkingRepository.getVehicleCost(aa.getVehicleType());
				Integer no = aa.getNumberOfVehicles();
				parkingPrice = parkingPrice + vehicleCost * no;
				listOfParkings.add(aa.getVehicleType());
			}
			finalPrice = roomPrice + parkingPrice * numberOfDays;
			List<Parking> parking = parkingRepository.findByListOfVehicleType(listOfParkings);
			booking.setParking(parking);
			booking.setParkingCost(parkingPrice * numberOfDays);
			booking.setTotalCost(finalPrice);
			return bookingRepository.save(booking);

		} catch (Exception e) {
			if (e.getMessage() == "No value present") {
				throw new NotFoundException(e.getMessage() + " for parking with id " + id);

			} else {
				throw new InternalServerException(e);
			}
		}

	}

	@PostMapping(value = "checkout")
	public ResponseEntity<?> checkout(@RequestParam String roomNumbers, @RequestBody CheckoutDto checkoutDto) {
		try {
			transactionService.checkout(roomNumbers, checkoutDto);
			return ResponseEntity.status(HttpStatus.OK)
					.body("Successfully checked out room numbers " + roomNumbers);
		} catch (Exception e) {
			throw new InternalServerException(e);

		}

	}

	@GetMapping("transactions")
	public List<Transaction> getAllTransactions() {
		try {
			return transactionRepository.findAll();
		} catch (Exception e) {

			throw new InternalServerException(e.getMessage());

		}

	}

}
