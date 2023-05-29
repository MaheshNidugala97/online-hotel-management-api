package com.sdp.hms.exception;

import org.springframework.stereotype.Service;

@Service
public class ApiRequestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiRequestException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ApiRequestException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ApiRequestException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
