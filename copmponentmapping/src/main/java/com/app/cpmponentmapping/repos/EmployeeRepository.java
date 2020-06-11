package com.app.cpmponentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import com.app.cpmponentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
