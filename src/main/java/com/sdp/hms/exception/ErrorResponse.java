package com.sdp.hms.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private String message;
	private HttpStatus status;
	private LocalDateTime timestamp;
	private String path;

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String message, HttpStatus status, LocalDateTime timestamp, String path) {
		super();
		this.message = message;
		this.status = status;
		this.timestamp = timestamp;
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", status=" + status + ", timestamp=" + timestamp + ", path="
				+ path + "]";
	}

}
