package com.sdp.hms.dto;

public class CategoryResponseDto {
	
	private Long id;
	
	private String title;
	
	private Integer rooms;

	private Long size;

	private Double price;

	private Integer maxPeopleAllowed;
	
	private String imageData;

	public CategoryResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryResponseDto(Long id, String title, Integer rooms, Long size, Double price, Integer maxPeopleAllowed,
			String imageData) {
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

	public String getImageData() {
		return imageData;
	}

	public void setImageData(String imageData) {
		this.imageData = imageData;
	}

	@Override
	public String toString() {
		return "CategoryResponseDto [id=" + id + ", title=" + title + ", rooms=" + rooms + ", size=" + size + ", price="
				+ price + ", maxPeopleAllowed=" + maxPeopleAllowed + ", imageData=" + imageData + "]";
	}
	
	

}
