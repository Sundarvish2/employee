package com.project.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.employee.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value="select * from employee where name=?",nativeQuery = true)
	public List<Employee> getByName(String name);

	@Query(value="select * from employee where gender=?",nativeQuery = true)
	public List<Employee> getByGender(String gender);
	
	@Query(value="select * from employee where age=?",nativeQuery = true)
	public List<Employee> getByAge(int id);

}
