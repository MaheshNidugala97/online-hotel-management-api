package com.sdp.hms.dto;

import java.time.LocalDateTime;

public class DatesDto {

	private LocalDateTime arrivalDate;

	private LocalDateTime deptDate;

	public DatesDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatesDto(LocalDateTime arrivalDate, LocalDateTime deptDate) {
		super();
		this.arrivalDate = arrivalDate;
		this.deptDate = deptDate;
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

	@Override
	public String toString() {
		return "DatesDto [arrivalDate=" + arrivalDate + ", deptDate=" + deptDate + "]";
	}

}
