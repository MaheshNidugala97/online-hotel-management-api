package com.sdp.hms.dto;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class CategoryDto {

	private String title;

	private Integer rooms;

	private Double size;

	private Double price;

	private Integer maxPeopleAllowed;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String title, Integer rooms, Double size, Double price, Integer maxPeopleAllowed) {
		super();
		this.title = title;
		this.rooms = rooms;
		this.size = size;
		this.price = price;
		this.maxPeopleAllowed = maxPeopleAllowed;
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

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
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

	@Override
	public String toString() {
		return "CategoryDto [title=" + title + ", rooms=" + rooms + ", size=" + size + ", price=" + price
				+ ", maxPeopleAllowed=" + maxPeopleAllowed + "]";
	}

}
