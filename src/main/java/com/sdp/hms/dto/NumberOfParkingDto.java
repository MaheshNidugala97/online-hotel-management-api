package com.sdp.hms.dto;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class NumberOfParkingDto {

	private String vehicleType;

	private Integer numberOfVehicles;

	public NumberOfParkingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NumberOfParkingDto(String vehicleType, Integer numberOfVehicles) {
		super();
		this.vehicleType = vehicleType;
		this.numberOfVehicles = numberOfVehicles;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Integer getNumberOfVehicles() {
		return numberOfVehicles;
	}

	public void setNumberOfVehicles(Integer numberOfVehicles) {
		this.numberOfVehicles = numberOfVehicles;
	}

	@Override
	public String toString() {
		return "NumberOfParkingDto [vehicleType=" + vehicleType + ", numberOfVehicles=" + numberOfVehicles + "]";
	}

}
