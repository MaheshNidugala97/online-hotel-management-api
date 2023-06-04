package com.sdp.hms.service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.sdp.hms.dao.CategoryRepository;
import com.sdp.hms.dto.CategoryDto;
import com.sdp.hms.entity.RoomCategory;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	public void addCategory(CategoryDto categoryDto) {
		RoomCategory roomCategory = new RoomCategory();
		roomCategory.setTitle(categoryDto.getTitle());
		roomCategory.setRooms(categoryDto.getRooms());
		roomCategory.setSize(categoryDto.getSize());
		roomCategory.setPrice(categoryDto.getPrice());
		categoryRepository.save(roomCategory);
	}

	public void updateCategory(RoomCategory roomCategory, CategoryDto categoryDto) {
		roomCategory.setTitle(categoryDto.getTitle());
		roomCategory.setRooms(categoryDto.getRooms());
		roomCategory.setSize(categoryDto.getSize());
		roomCategory.setPrice(categoryDto.getPrice());
		categoryRepository.save(roomCategory);
	}    

	public RoomCategory updateSpecificCategory(Long id, Map<String, Object> fields) {
	     RoomCategory roomCategory = categoryRepository.findById(id).get();

		if (roomCategory!=null) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(RoomCategory.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, roomCategory, value);
			});
			return categoryRepository.save(roomCategory);
		}
		return null;
	}

}
