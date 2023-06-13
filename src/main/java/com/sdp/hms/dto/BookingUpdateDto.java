package com.sdp.hms.dto;

import java.util.List;
import java.util.Optional;

public class BookingUpdateDto {

	private Optional<List<NumberOfParkingDto>> parkingList;

	private String estimatedCost;

	private String arrivalDate;

	private String departureDate;

	public BookingUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingUpdateDto(Optional<List<NumberOfParkingDto>> parkingList, String estimatedCost, String arrivalDate,
			String departureDate) {
		super();
		this.parkingList = parkingList;
		this.estimatedCost = estimatedCost;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	public Optional<List<NumberOfParkingDto>> getParkingList() {
		return parkingList;
	}

	public void setParkingList(Optional<List<NumberOfParkingDto>> parkingList) {
		this.parkingList = parkingList;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	@Override
	public String toString() {
		return "BookingUpdateDto [parkingList=" + parkingList + ", estimatedCost=" + estimatedCost + ", arrivalDate="
				+ arrivalDate + ", departureDate=" + departureDate + "]";
	}

}
