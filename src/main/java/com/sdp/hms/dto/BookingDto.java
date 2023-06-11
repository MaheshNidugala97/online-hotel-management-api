package com.sdp.hms.dto;
	
import java.util.List;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class BookingDto {

	private List<GuestsDto> guests;

	private String arrivalDate;

	private String departureDate;

	private Integer numberOfGuests;

	private String parkingType;

	private String paymentType;

	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingDto(List<GuestsDto> guests, String arrivalDate, String departureDate,
			Integer numberOfGuests, String parkingType, String paymentType) {
		super();
		this.guests = guests;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.numberOfGuests = numberOfGuests;
		this.parkingType = parkingType;
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

	public String getParkingType() {
		return parkingType;
	}

	public void setParkingType(String parkingType) {
		this.parkingType = parkingType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "BookingDto [guests=" + guests + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate
				+ ", numberOfGuests=" + numberOfGuests + ", parkingType=" + parkingType + ", paymentType=" + paymentType
				+ "]";
	}

}
