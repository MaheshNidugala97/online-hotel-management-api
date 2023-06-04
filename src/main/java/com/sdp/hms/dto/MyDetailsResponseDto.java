package com.sdp.hms.dto;

/**
 * 
 * @author mahesh nidugala
 *
 */

public class MyDetailsResponseDto {
	
	private String email;
	
	private String roles;
	
	public MyDetailsResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyDetailsResponseDto(String email, String roles) {
		super();
		this.email = email;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return roles;
	}

	public void setRole(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "MyDetailsResponseDto [email=" + email + ", roles=" + roles + "]";
	}
	
		

}
