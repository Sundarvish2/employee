package com.project.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {

	@ExceptionHandler(NameNotFoundExceeption.class)
	public ResponseEntity<Object> nameNotFoundExceptionHandling(NameNotFoundExceeption ne) {
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GenderNotFoundException.class)
	public ResponseEntity<Object> genderNotFoundExceptionHandling(GenderNotFoundException ne) {
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AgeNotFoundException.class)
	public ResponseEntity<Object> ageNotFoundExceptionHandling(AgeNotFoundException ne) {
		return new ResponseEntity<>(ne.getMessage(),HttpStatus.NOT_FOUND);
	}
}
