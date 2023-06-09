package com.sdp.hms.service;

import java.io.IOException;
import java.lang.reflect.Field;
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
import com.sdp.hms.util.ImageUtil;

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

//	public ResponseEntity<RoomCategory> getA(Long id, String token) {
//		WebClient webClient = WebClient.create("http://localhost:8088/");
//		return webClient.get().uri("hms/admin/category/id/" + id).header("Authorization", token).retrieve()
//				.toEntity(RoomCategory.class).block();
//	}

	public void addRoom(RoomDto roomdto, RoomCategory roomCategory, MultipartFile file) throws IOException {
		try {

			Rooms rooms = new Rooms();
			rooms.setRoomNo(roomdto.getRoomNo());
			rooms.setCategory(roomCategory);
			rooms.setIsActive(roomdto.getIsActive());
			rooms.setIsInventoryAvailable(roomdto.getIsInventoryAvailable());
			rooms.setIsCleaned(roomdto.getIsCleaned());
			rooms.setImageData(ImageUtil.compressImage(file.getBytes()));
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
		rooms.setImageData(ImageUtil.compressImage(file.getBytes()));
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
	
	
	

}
