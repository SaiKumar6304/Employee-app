package com.innovate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.innovate.Exceptions.BussinessException;
@ControllerAdvice
@RestController
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public ResponseEntity<String> businessException(BussinessException exception) {
		
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
	

}
