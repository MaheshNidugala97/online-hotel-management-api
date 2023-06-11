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

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	private List<Guests> guests;

	@Column(name = "arrival_date", nullable = false)
	private LocalDateTime arrivalDate;

	@Column(name = "departure_date", nullable = false)
	private LocalDateTime departureDate;

	@Column(name = "number_of_guests", nullable = false)
	private Integer numberOfGuests;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "guest_parkings", joinColumns = {
			@JoinColumn(name = "booking_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "parking_id", referencedColumnName = "id") })
	private List<Parking> parking = new ArrayList<>();

	@Column(nullable = false)
	private Double amount;

	@Column(name = "payment_type", nullable = false)
	private String paymentType;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Long id, List<Guests> guests, LocalDateTime arrivalDate, LocalDateTime departureDate,
			Integer numberOfGuests, List<Parking> parking, Double amount, String paymentType) {
		super();
		this.id = id;
		this.guests = guests;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.numberOfGuests = numberOfGuests;
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
		return "Booking [id=" + id + ", guests=" + guests + ", arrivalDate=" + arrivalDate + ", departureDate="
				+ departureDate + ", numberOfGuests=" + numberOfGuests + ", parking=" + parking + ", amount=" + amount
				+ ", paymentType=" + paymentType + "]";
	}

}
