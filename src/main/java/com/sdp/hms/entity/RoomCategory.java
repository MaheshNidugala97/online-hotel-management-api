package com.sdp.hms.entity;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Entity
@Table(name = "room_category")
public class RoomCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private Integer rooms;

	@Column(nullable = false)
	private Long size;

	@Column(nullable = false)
	private Double price;

	@Column(name = "max_people_allowed")
	private Integer maxPeopleAllowed;

	@Column(name = "imagedata", length = 1000)
	private byte[] imageData;

	public RoomCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoomCategory(Long id, String title, Integer rooms, Long size, Double price, Integer maxPeopleAllowed,
			byte[] imageData) {
		super();
		this.id = id;
		this.title = title;
		this.rooms = rooms;
		this.size = size;
		this.price = price;
		this.maxPeopleAllowed = maxPeopleAllowed;
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMaxPeopleAllowed() {
		return maxPeopleAllowed;
	}

	public void setMaxPeopleAllowed(Integer maxPeopleAllowed) {
		this.maxPeopleAllowed = maxPeopleAllowed;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "RoomCategory [id=" + id + ", title=" + title + ", rooms=" + rooms + ", size=" + size + ", price="
				+ price + ", maxPeopleAllowed=" + maxPeopleAllowed + ", imageData=" + Arrays.toString(imageData) + "]";
	}

}
