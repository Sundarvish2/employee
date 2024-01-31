package com.project.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employee.entity.Employee;
import com.project.employee.exception.AgeNotFoundException;
import com.project.employee.exception.GenderNotFoundException;
import com.project.employee.exception.NameNotFoundExceeption;
import com.project.employee.repo.EmployeeRepo;
import com.project.employee.service.EmployeeService;

@CrossOrigin(value = "http://localhost:4200/")
@RestController
@RequestMapping(value = "/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empSer;
	@Autowired
	EmployeeRepo repo;

	@PostMapping(value = "/add")
	public String insertEmployee(@RequestBody List<Employee> e) {
		return empSer.insertEmployee(e);
	}

	@PostMapping(value = "/ad")
	public String insertEmployee(@RequestBody Employee e) {
		return empSer.insertEmployee(e);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return empSer.deleteEmployee(id);
	}

	@GetMapping(value = "/get/{id}")
	public Employee getEmp(@PathVariable int id) {
		return empSer.getEmp(id);
	}

	@GetMapping(value = "/gettt")
	public List<Employee> getAll() {
		return empSer.getAll();
	}

	@GetMapping(value = "gett/{from}/{to}")
	public List<Employee> getEmpl(@PathVariable("from") int salary1, @PathVariable("to") int salary2) {
		return empSer.getEmpl(salary1, salary2);
	}

	@PatchMapping(value = "/patch/{id}")
	public Employee putEmp(@PathVariable int id, @RequestBody Employee e) {
		Employee a = repo.findById(id).get();
		a.setName(e.getName());
		repo.save(a);
		return a;
	}

	@PostMapping(value = "/addd")
	public String insertEmployeee(@RequestBody Employee e) {
		return empSer.insertEmployeee(e);
	}
	@GetMapping(value="/getbyname/{name}")
	public List<Employee> getByName(@PathVariable String name) throws NameNotFoundExceeption{
		return empSer.getByName(name);
	}
	@GetMapping(value="/getbygender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) throws GenderNotFoundException {
		return empSer.getByGender(gender);
	}

	@GetMapping(value="/getbyage/{age}")
	public List<Employee> getByAge(@PathVariable int age) throws AgeNotFoundException {
		return empSer.getByAge(age);
	}
	
	@PutMapping(value = "/update/{id}")
	public Employee update(@RequestBody Employee e,@PathVariable int id) {
		return empSer.update(e,id);
	}

}
