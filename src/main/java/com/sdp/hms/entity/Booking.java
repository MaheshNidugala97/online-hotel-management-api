package com.sdp.hms.entity;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Entity
@Table(name = "bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "arrival_date", nullable = false)
	private LocalDateTime arrivalDate;

	@Column(name = "departure_date", nullable = false)
	private LocalDateTime departureDate;

	@Column(name = "number_of_guests", nullable = false)
	private Integer numberOfGuests;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "rooms")
	private Rooms rooms;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "parking")
	private Parking parking;

	@Column(nullable = false)
	private Double amount;

	@Column(name = "payment_type", nullable = false)
	private String paymentType;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Long id, String userName, LocalDateTime arrivalDate, LocalDateTime departureDate,
			Integer numberOfGuests, Rooms rooms, Parking parking, Double amount, String paymentType) {
		super();
		this.id = id;
		this.userName = userName;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.numberOfGuests = numberOfGuests;
		this.rooms = rooms;
		this.parking = parking;
		this.amount = amount;
		this.paymentType = paymentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Rooms getRooms() {
		return rooms;
	}

	public void setRooms(Rooms rooms) {
		this.rooms = rooms;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", userName=" + userName + ", arrivalDate=" + arrivalDate + ", departureDate="
				+ departureDate + ", numberOfGuests=" + numberOfGuests + ", rooms=" + rooms + ", parking=" + parking
				+ ", amount=" + amount + ", paymentType=" + paymentType + "]";
	}

}
