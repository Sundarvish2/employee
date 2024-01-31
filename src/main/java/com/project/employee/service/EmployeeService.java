package com.project.employee.service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employee.dao.EmployeeDao;
import com.project.employee.entity.Employee;
import com.project.employee.exception.AgeNotFoundException;
import com.project.employee.exception.GenderNotFoundException;
import com.project.employee.exception.NameNotFoundExceeption;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String insertEmployee(List<Employee> e) {
		return dao.insertEmployee(e);
	}

	public String insertEmployee(Employee e) {
		return dao.insertEmployee(e);
	}

	public String deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

	public Employee getEmp(int id) {
		return dao.getEmp(id);
	}

	public List<Employee> getEmpl(int salary1, int salary2) {
		List<Employee> q = dao.getAll();
		List<Employee> a = q.stream().filter(x -> x.getSalary() > salary1 && x.getSalary() < salary2)
				.collect(Collectors.toList());
		return a;
	}

	public List<Employee> getAll() {
		return dao.getAll();
	}

	public String insertEmployeee(Employee e) {
		try {
			if (e.getAge() > 18) {
				return dao.insertEmployee(e);
			} else {
				throw new AgeNotEligible("Age Not Eligible");
			}
		} catch (AgeNotEligible e1) {
			return e1.getMessage();
		}
	}

	public List<Employee> getByName(String name) throws NameNotFoundExceeption {
		List<Employee> list = dao.getByName(name);
		if (list.isEmpty()) {
			throw new NameNotFoundExceeption("their is no data for " + name);
		} else {
			return list;
		}
	}

	public List<Employee> getByGender(String gender) throws GenderNotFoundException {
		List<Employee> list = dao.getByGender(gender);
		if (list.isEmpty()) {
			throw new GenderNotFoundException("their is no data for " + gender);
		} else {
			return list;
		}
	}
	
	public List<Employee> getByAge(int age) throws AgeNotFoundException {
		List<Employee> list = dao.getByAge(age);
		if (list.isEmpty()) {
			throw new AgeNotFoundException("their is no data for " + age);
		} else {
			return list;
		}
	}

	public Employee update(Employee e, int id) {
		return dao.update(e,id);

	}

}
