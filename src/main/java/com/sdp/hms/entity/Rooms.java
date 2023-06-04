//package com.sdp.hms.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
///**
// * 
// * @author mahesh nidugala
// *
// */
//
//@Entity
//@Table(name = "rooms")
//public class Rooms {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@Column
//	private String title;
//
//	@Column
//	private String image;
//
//	@Column
//	private String price;
//
//	@Column
//	private Integer beds;
//
//
//	@Column(name = "is_occupied")
//	private Boolean isOccupied;
//
//	@Column(name = "inventory_available")
//	private Boolean inventoryAvailable;
//
//	@Column(name = "cleaning_status")
//	private Boolean cleaningStatus;
//
//	public Rooms() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Rooms(Long id, String title, String image, String price, Integer beds, Boolean isOccupied,
//			Boolean inventoryAvailable, Boolean cleaningStatus) {
//		super();
//		this.id = id;
//		this.title = title;
//		this.image = image;
//		this.price = price;
//		this.beds = beds;
//		this.isOccupied = isOccupied;
//		this.inventoryAvailable = inventoryAvailable;
//		this.cleaningStatus = cleaningStatus;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getImage() {
//		return image;
//	}
//
//	public void setImage(String image) {
//		this.image = image;
//	}
//
//	public String getPrice() {
//		return price;
//	}
//
//	public void setPrice(String price) {
//		this.price = price;
//	}
//
//	public Integer getBeds() {
//		return beds;
//	}
//
//	public void setBeds(Integer beds) {
//		this.beds = beds;
//	}
//
//	public Boolean getIsOccupied() {
//		return isOccupied;
//	}
//
//	public void setIsOccupied(Boolean isOccupied) {
//		this.isOccupied = isOccupied;
//	}
//
//	public Boolean getInventoryAvailable() {
//		return inventoryAvailable;
//	}
//
//	public void setInventoryAvailable(Boolean inventoryAvailable) {
//		this.inventoryAvailable = inventoryAvailable;
//	}
//
//	public Boolean getCleaningStatus() {
//		return cleaningStatus;
//	}
//
//	public void setCleaningStatus(Boolean cleaningStatus) {
//		this.cleaningStatus = cleaningStatus;
//	}
//
//	@Override
//	public String toString() {
//		return "Rooms [id=" + id + ", title=" + title + ", image=" + image + ", price=" + price + ", beds=" + beds
//				+ ", isOccupied=" + isOccupied + ", inventoryAvailable=" + inventoryAvailable + ", cleaningStatus="
//				+ cleaningStatus + "]";
//	}
//
//	
//
//}
