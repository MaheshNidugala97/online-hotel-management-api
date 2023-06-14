package com.sdp.hms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "booking_id", nullable = false)
	private Long bookingId;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "arrival_date", nullable = false)
	private LocalDateTime arrivalDate;

	@Column(name = "departure_date", nullable = false)
	private LocalDateTime deptDate;

	@Column(name = "final_cost", nullable = false)
	private String finalCost;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long id, Long bookingId, String username, LocalDateTime arrivalDate, LocalDateTime deptDate,
			String finalCost) {
		super();
		this.id = id;
		this.bookingId = bookingId;
		this.username = username;
		this.arrivalDate = arrivalDate;
		this.deptDate = deptDate;
		this.finalCost = finalCost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDateTime getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(LocalDateTime deptDate) {
		this.deptDate = deptDate;
	}

	public String getFinalCost() {
		return finalCost;
	}

	public void setFinalCost(String finalCost) {
		this.finalCost = finalCost;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", bookingId=" + bookingId + ", username=" + username + ", arrivalDate="
				+ arrivalDate + ", deptDate=" + deptDate + ", finalCost=" + finalCost + "]";
	}

}
