package com.sdp.hms.dto;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class EmailDto {

	private String email;

	public EmailDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmailDto(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailDto [email=" + email + "]";
	}

}
