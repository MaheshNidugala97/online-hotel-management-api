package com.sdp.hms.dto;

import java.util.List;

import com.sdp.hms.entity.Role;

public class AuthResponseDto {
    private String accessToken;

	public AuthResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResponseDto(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


	@Override
	public String toString() {
		return "AuthResponseDto [accessToken=" + accessToken + "]";
	}


	

    
}