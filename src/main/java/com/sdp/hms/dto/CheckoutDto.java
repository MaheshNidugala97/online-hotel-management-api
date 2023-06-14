package com.sdp.hms.dto;

public class CheckoutDto {

	private String username;

	private Long bookingId;

	private String arrivalDate;

	private String deptDate;

	private String finalCost;

	public CheckoutDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckoutDto(String username, Long bookingId, String arrivalDate, String deptDate, String finalCost) {
		super();
		this.username = username;
		this.bookingId = bookingId;
		this.arrivalDate = arrivalDate;
		this.deptDate = deptDate;
		this.finalCost = finalCost;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(String deptDate) {
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
		return "CheckoutDto [username=" + username + ", bookingId=" + bookingId + ", arrivalDate=" + arrivalDate
				+ ", deptDate=" + deptDate + ", finalCost=" + finalCost + "]";
	}

}
