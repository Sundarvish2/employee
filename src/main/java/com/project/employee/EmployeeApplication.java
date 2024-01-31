package com.project.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(info=@Info(title = "EMPLOYEE API",version = "1.0",description = "This is Employee details API"))
@SpringBootApplication
public class EmployeeApplication{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	
}
