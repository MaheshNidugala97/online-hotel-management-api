package com.sdp.hms.dto;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class CategoryDto {

	private String title;

	private Integer rooms;

	private String size;

	private String price;

	private Integer maxPeopleAllowed;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String title, Integer rooms, String size, String price, Integer maxPeopleAllowed) {
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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
