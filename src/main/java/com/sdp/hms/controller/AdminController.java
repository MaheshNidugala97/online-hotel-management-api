package com.sdp.hms.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sdp.hms.dao.CategoryRepository;
import com.sdp.hms.dto.CategoryDto;
import com.sdp.hms.entity.RoomCategory;
import com.sdp.hms.exception.ApiRequestException;
import com.sdp.hms.exception.InternalServerException;
import com.sdp.hms.exception.NotFoundException;
import com.sdp.hms.service.CategoryService;

/**
 * 
 * @author mahesh nidugala
 *
 */

@RestController
@RequestMapping("/hms/admin")
public class AdminController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryRepository categoryRepository;

	@PostMapping("category/add")
	public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
		try {
			if (categoryRepository.existsByTitle(categoryDto.getTitle())
					&& categoryRepository.existsBySize(categoryDto.getSize())) {
				throw new ApiRequestException("Category with  " + categoryDto.getTitle() + " " + categoryDto.getSize()
						+ " mts sqr already Exists");
			}
			categoryService.addCategory(categoryDto);
			return ResponseEntity.status(HttpStatus.OK).body(categoryDto.getTitle() + " successfully added");
		} catch (ApiRequestException e) {
			throw new ApiRequestException(e.getMessage());
		} catch (Exception e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@GetMapping("category")
	public List<RoomCategory> getAllCategory() {
		try {
			return categoryRepository.findAll();
		} catch (Exception e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@DeleteMapping("category/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
		try {
			categoryRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " successfully added");
		} catch (Exception e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@PutMapping("category/update/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
		try {
			RoomCategory roomCategory = categoryRepository.findById(id).get();
			if (roomCategory == null) {
				throw new NotFoundException("Category with " + id + " not found");
			}
			categoryService.updateCategory(roomCategory, categoryDto);
			return ResponseEntity.status(HttpStatus.OK).body("Category with id " + id + " successfully updated");
		} catch (NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		} catch (InternalServerException e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

	@PatchMapping("category/update/{id}")
	public RoomCategory updateSpecificCategory(@PathVariable Long id,@RequestBody Map<String, Object> fields) {
		try {
			return categoryService.updateSpecificCategory(id, fields);
		} catch (NotFoundException e) {
			throw new NotFoundException(e.getMessage());
		} catch (InternalServerException e) {
			throw new InternalServerException("Internal Server Error");
		}

	}

}
