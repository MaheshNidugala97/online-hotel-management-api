package com.sdp.hms.entity;

import java.util.Arrays;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Entity
@Table(name = "rooms")
public class Rooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "room_no")
	private Integer roomNo;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "category")
	private RoomCategory category;

	@Column(name = "active")
	private Boolean isActive;

	@Column(name = "inventory_available")
	private Boolean isInventoryAvailable;

	@Column(name = "is_cleaned")
	private Boolean isCleaned;

	@Column(name = "imagedata", length = 1000)
	private byte[] imageData;

	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rooms(Long id, Integer roomNo, RoomCategory category, Boolean isActive, Boolean isInventoryAvailable,
			Boolean isCleaned, byte[] imageData) {
		super();
		this.id = id;
		this.roomNo = roomNo;
		this.category = category;
		this.isActive = isActive;
		this.isInventoryAvailable = isInventoryAvailable;
		this.isCleaned = isCleaned;
		this.imageData = imageData;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}

	public RoomCategory getCategory() {
		return category;
	}

	public void setCategory(RoomCategory category) {
		this.category = category;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Boolean getIsInventoryAvailable() {
		return isInventoryAvailable;
	}

	public void setIsInventoryAvailable(Boolean isInventoryAvailable) {
		this.isInventoryAvailable = isInventoryAvailable;
	}

	public Boolean getIsCleaned() {
		return isCleaned;
	}

	public void setIsCleaned(Boolean isCleaned) {
		this.isCleaned = isCleaned;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", roomNo=" + roomNo + ", category=" + category + ", isActive=" + isActive
				+ ", isInventoryAvailable=" + isInventoryAvailable + ", isCleaned=" + isCleaned + ", imageData="
				+ Arrays.toString(imageData) + "]";
	}

}
