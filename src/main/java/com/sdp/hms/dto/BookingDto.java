package com.sdp.hms.dto;

import java.util.List;
import java.util.Optional;

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

	private Optional<List<NumberOfParkingDto>> parkingList;

	private String paymentType;

	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDto(List<GuestsDto> guests, String email, String arrivalDate, String departureDate,
			Integer numberOfGuests, Optional<List<NumberOfParkingDto>> parkingList, String paymentType) {
		super();
		this.guests = guests;
		this.email = email;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.numberOfGuests = numberOfGuests;
		this.parkingList = parkingList;
		this.paymentType = paymentType;
	}

	public List<GuestsDto> getGuests() {
		return guests;
	}

	public void setGuests(List<GuestsDto> guests) {
		this.guests = guests;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public String toString() {
		return "BookingDto [guests=" + guests + ", email=" + email + ", arrivalDate=" + arrivalDate + ", departureDate="
				+ departureDate + ", numberOfGuests=" + numberOfGuests + ", parkingList=" + parkingList
				+ ", paymentType=" + paymentType + "]";
	}

}
