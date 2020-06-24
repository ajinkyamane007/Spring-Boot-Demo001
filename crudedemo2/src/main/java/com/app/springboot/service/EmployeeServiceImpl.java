 package com.app.springboot.service;

import java.util.List;
import java.util.Optional;
import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.springboot.dao.EmployeeRepository;
import com.app.springboot.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired 
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository=theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee=null;
		if(result.isPresent()) {
			theEmployee=result.get();
		}else {
			// we dodn't find employee
			throw new RuntimeErrorException(null, "Did not find employee id : "+theId);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteByID(int theId) {
		employeeRepository.deleteById(theId);
	}

}