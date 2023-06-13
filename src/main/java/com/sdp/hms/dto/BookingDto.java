package com.sdp.hms.dto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class BookingDto {

	private List<GuestsDto> guests;

	private String email;

	private String arrivalDate;

	private String departureDate;

	private Integer numberOfGuests;

	private String totalCost;

	private Optional<List<NumberOfParkingDto>> parkingList;

	private String paymentType;

	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDto(List<GuestsDto> guests, String email, String arrivalDate, String departureDate,
			Integer numberOfGuests, String totalCost, Optional<List<NumberOfParkingDto>> parkingList,
			String paymentType) {
		super();
		this.guests = guests;
		this.email = email;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.numberOfGuests = numberOfGuests;
		this.totalCost = totalCost;
		this.parkingList = parkingList;
		this.paymentType = paymentType;
	}

	public List<GuestsDto> getGuests() {
		return guests;
	}

	public void setGuests(List<GuestsDto> guests) {
		this.guests = guests;
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

	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public Optional<List<NumberOfParkingDto>> getParkingList() {
		return parkingList;
	}

	public void setParkingList(Optional<List<NumberOfParkingDto>> parkingList) {
		this.parkingList = parkingList;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "BookingDto [guests=" + guests + ", email=" + email + ", arrivalDate=" + arrivalDate + ", departureDate="
				+ departureDate + ", numberOfGuests=" + numberOfGuests + ", totalCost=" + totalCost + ", parkingList="
				+ parkingList + ", paymentType=" + paymentType + "]";
	}

}
