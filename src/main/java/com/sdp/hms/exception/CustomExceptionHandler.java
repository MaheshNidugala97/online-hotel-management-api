package com.sdp.hms.exception;

import java.time.LocalDateTime;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import jakarta.servlet.http.HttpServletRequest;

/**
 * 
 * @author mahesh nidugala
 *
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class CustomExceptionHandler {

	@ExceptionHandler(value= {ApiRequestException.class})
	public ResponseEntity<Object> handleBadRequest(HttpServletRequest req,ApiRequestException ex) {
		
		ErrorResponse errorResponse=new  ErrorResponse(ex.getMessage().toString(), HttpStatus.BAD_REQUEST, LocalDateTime.now(),req.getRequestURI());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value= {InternalServerException.class})
	public ResponseEntity<Object> handleInternalServerError(HttpServletRequest req,InternalServerException ex) {
		
		ErrorResponse errorResponse=new  ErrorResponse(ex.getMessage().toString(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now(),req.getRequestURI());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value= {AccessDeniedException.class})
	public ResponseEntity<Object> handleUnauthorized(HttpServletRequest req,AccessDeniedException ex) {
		
		ErrorResponse errorResponse=new  ErrorResponse(ex.getMessage().toString(), HttpStatus.UNAUTHORIZED, LocalDateTime.now(),req.getRequestURI());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.UNAUTHORIZED);
	}
	

	@ExceptionHandler(value= {NotFoundException.class})
	public ResponseEntity<Object> hanldeNotFound(HttpServletRequest req,NotFoundException ex) {
		
		ErrorResponse errorResponse=new  ErrorResponse(ex.getMessage().toString(), HttpStatus.NOT_FOUND, LocalDateTime.now(),req.getRequestURI());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	

}
