package com.sdp.hms.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

	@Column(name = "email", nullable = false)
	private String email;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "booking_id")
	private List<Guests> guests;

	@Column(name = "arrival_date", nullable = false)
	private LocalDateTime arrivalDate;

	@Column(name = "departure_date", nullable = false)
	private LocalDateTime departureDate;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "room_id")
	private List<Rooms> rooms;

	@Column(name = "number_of_guests", nullable = false)
	private Integer numberOfGuests;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "guest_parkings", joinColumns = {
			@JoinColumn(name = "booking_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "parking_id", referencedColumnName = "id") })
	private List<Parking> parking = new ArrayList<>();

	@Column(name = "total_cost", nullable = false)
	private Double totalCost;

	@Column(name = "payment_type", nullable = false)
	private String paymentType;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Long id, String email, List<Guests> guests, LocalDateTime arrivalDate, LocalDateTime departureDate,
			List<Rooms> rooms, Integer numberOfGuests, List<Parking> parking, Double totalCost, String paymentType) {
		super();
		this.id = id;
		this.email = email;
		this.guests = guests;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.rooms = rooms;
		this.numberOfGuests = numberOfGuests;
		this.parking = parking;
		this.totalCost = totalCost;
		this.paymentType = paymentType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Guests> getGuests() {
		return guests;
	}

	public void setGuests(List<Guests> guests) {
		this.guests = guests;
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

	public List<Rooms> getRooms() {
		return rooms;
	}

	public void setRooms(List<Rooms> rooms) {
		this.rooms = rooms;
	}

	public Integer getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public List<Parking> getParking() {
		return parking;
	}

	public void setParking(List<Parking> parking) {
		this.parking = parking;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
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
		return "Booking [id=" + id + ", email=" + email + ", guests=" + guests + ", arrivalDate=" + arrivalDate
				+ ", departureDate=" + departureDate + ", rooms=" + rooms + ", numberOfGuests=" + numberOfGuests
				+ ", parking=" + parking + ", totalCost=" + totalCost + ", paymentType=" + paymentType + "]";
	}

}
