package com.sdp.hms.dto;


/**
 * 
 * @author mahesh nidugala
 *
 */


public class CategoryDto {
	
	private String title;
	
	private Integer rooms;
	
	private Long size;
	
	private Long price;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(String title, Integer rooms, Long size, Long price) {
		super();
		this.title = title;
		this.rooms = rooms;
		this.size = size;
		this.price = price;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CategoryDto [title=" + title + ", rooms=" + rooms + ", size=" + size + ", price=" + price + "]";
	}
	
}
