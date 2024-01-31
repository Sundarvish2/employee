package com.project.employee.exception;

public class GenderNotFoundException extends Exception {

	public GenderNotFoundException(String gender) {
		super(gender);
	}
}
