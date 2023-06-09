package com.sdp.hms.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.multipart.MultipartFile;
import com.sdp.hms.dao.CategoryRepository;
import com.sdp.hms.dto.CategoryDto;
import com.sdp.hms.entity.RoomCategory;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Service
public class CategoryService  {

	@Autowired
	CategoryRepository categoryRepository;
	



	public void addCategory(CategoryDto categoryDto, MultipartFile file) throws IOException {
		RoomCategory roomCategory = new RoomCategory();
		roomCategory.setTitle(categoryDto.getTitle());
		roomCategory.setRooms(categoryDto.getRooms());
		roomCategory.setSize(categoryDto.getSize());
		roomCategory.setPrice(categoryDto.getPrice());
		roomCategory.setMaxPeopleAllowed(categoryDto.getMaxPeopleAllowed());
		roomCategory.setImageData(file.getBytes());
		categoryRepository.save(roomCategory);
	}

	public void updateCategory(RoomCategory roomCategory, CategoryDto categoryDto, MultipartFile file)
			throws IOException {
		roomCategory.setTitle(categoryDto.getTitle());
		roomCategory.setRooms(categoryDto.getRooms());
		roomCategory.setSize(categoryDto.getSize());
		roomCategory.setPrice(categoryDto.getPrice());
		roomCategory.setMaxPeopleAllowed(categoryDto.getMaxPeopleAllowed());
		roomCategory.setImageData(file.getBytes());		
		categoryRepository.save(roomCategory);
	}

	public RoomCategory updateSpecificCategory(RoomCategory roomCategory, Optional<Map<String, Object>> fields) {
		if (roomCategory != null) {
			fields.get().forEach((key, value) -> {
				Field field = ReflectionUtils.findField(RoomCategory.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, roomCategory, value);
			});
			return categoryRepository.save(roomCategory);
		}
		return null;
	}
	
	
	

}
