package com.project.employee.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.employee.entity.Employee;
import com.project.employee.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	EmployeeRepo repo;

	public String insertEmployee(List<Employee> e) {
		repo.saveAll(e);
		return "Successfully Saved";
	}

	public String insertEmployee(Employee e) {
		repo.save(e);
		return "Successfully Saved";
	}

	public String deleteEmployee(int id) {
		repo.deleteById(id);
		return "Deleted Successfully";
	}

	public Employee getEmp(int id) {
		Employee q = repo.findById(id).get();
		return q;
	}

	public List<Employee> getAll() {
		return repo.findAll();
	}

	public List<Employee> getByName(String name) {
		return repo.getByName(name);
	}

	public List<Employee> getByGender(String gender) {
		return repo.getByGender(gender);
	}
	
	public List<Employee> getByAge(int age) {
		return repo.getByAge(age);
	}

	public Employee update(Employee e, int id) {

		Employee x = repo.findById(id).get();
		x.setName(e.getName());
		x.setSalary(e.getSalary());
		x.setAge(e.getAge());
		x.setGender(e.getGender());
		repo.save(x);
		return x;
	}

}
