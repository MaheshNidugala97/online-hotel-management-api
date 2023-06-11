package com.sdp.hms.dto;


/**
 * 
 * @author mahesh nidugala
 *
 */

public class GuestsDto {

	private String name;

	public GuestsDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GuestsDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GuestsDto [name=" + name + "]";
	}
	
	
}
