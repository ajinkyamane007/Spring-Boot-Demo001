package com.app.springboot.service;

import java.util.List;

import com.app.springboot.entity.Employee;

public interface EmployeeService {
	
	public List<Employee>findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteByID(int theId);

}
