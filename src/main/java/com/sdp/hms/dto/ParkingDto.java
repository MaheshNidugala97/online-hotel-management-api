package com.sdp.hms.dto;


/**
 * 
 * @author mahesh nidugala
 *
 */


public class ParkingDto {
	
	private String vehicleType;

	private Double price;

	public ParkingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParkingDto(String vehicleType, Double price) {
		super();
		this.vehicleType = vehicleType;
		this.price = price;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ParkingDto [vehicleType=" + vehicleType + ", price=" + price + "]";
	}
	
	

}
