package com.sdp.hms.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;
import com.sdp.hms.dao.RoomRepository;
import com.sdp.hms.dto.RoomDto;
import com.sdp.hms.entity.RoomCategory;
import com.sdp.hms.entity.Rooms;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Service
public class RoomService {

//	@Value("${online.getcategorybytitle.endpoint}")
//	private String categpryApiPath;

	@Autowired
	private RoomRepository roomRepository;

	private final String checkInTime = "12:00:00";
	private final String checkOutTime = "12:00:00";
	private final double roomServiceFees = 10.0;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public void addRoom(RoomDto roomdto, RoomCategory roomCategory, MultipartFile file) throws IOException {
		try {

			Rooms rooms = new Rooms();
			rooms.setRoomNo(roomdto.getRoomNo());
			rooms.setCategory(roomCategory);
			rooms.setIsActive(roomdto.getIsActive());
			rooms.setIsInventoryAvailable(roomdto.getIsInventoryAvailable());
			rooms.setIsCleaned(roomdto.getIsCleaned());
			rooms.setImageData(file.getBytes());
			roomRepository.save(rooms);
		} catch (Exception e) {
			throw e;
		}
	}

	public void updateRoom(Rooms rooms, RoomDto roomdto, RoomCategory roomCategory, MultipartFile file)
			throws IOException {
		rooms.setRoomNo(roomdto.getRoomNo());
		rooms.setCategory(roomCategory);
		rooms.setIsActive(roomdto.getIsActive());
		rooms.setIsInventoryAvailable(roomdto.getIsInventoryAvailable());
		rooms.setIsCleaned(roomdto.getIsCleaned());
		rooms.setImageData(file.getBytes());
		roomRepository.save(rooms);
	}

	public Rooms updateSpecificRooms(Rooms rooms, Optional<Map<String, Object>> fields) {
		if (rooms != null) {
			fields.get().forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Rooms.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, rooms, value);
			});
			return roomRepository.save(rooms);
		}
		return null;
	}

	public double getEstimatedPrice(String roomNumbers, String arrivalDate, String deptDate, Boolean isActive) {
		double totalRoomPrice = 0.0;
		List<Integer> listRoomNumbers = new ArrayList<>();
		String[] arrayRoomNumbers = roomNumbers.split(",");
		for (String roomNumber : arrayRoomNumbers) {
			Integer roomNo = Integer.parseInt(roomNumber);
			listRoomNumbers.add(roomNo);
		}
		List<Rooms> rooms = roomRepository.findByAllRoomNo(listRoomNumbers, isActive);
		long numberOfDays = calculateDays(arrivalDate, deptDate);
		Iterator<Rooms> iterator = rooms.iterator();
		while (iterator.hasNext()) {
			totalRoomPrice = totalRoomPrice + iterator.next().getCategory().getPrice();
		}
		double estimatedRoomPrice = totalRoomPrice * numberOfDays + roomServiceFees;
		return estimatedRoomPrice;
	}

	public long calculateDays(String arrivalDate, String deptDate) {
		LocalDateTime arrDate = LocalDateTime.parse(arrivalDate + " " + checkInTime, formatter);
		LocalDateTime depDate = LocalDateTime.parse(deptDate + " " + checkOutTime, formatter);
		long numberOfDays = arrDate.until(depDate, ChronoUnit.DAYS);
		return numberOfDays;
	}

//	public ResponseEntity<RoomCategory> getA(Long id, String token) {
//	WebClient webClient = WebClient.create("http://localhost:8088/");
//	return webClient.get().uri("hms/admin/category/id/" + id).header("Authorization", token).retrieve()
//			.toEntity(RoomCategory.class).block();
//}

}
