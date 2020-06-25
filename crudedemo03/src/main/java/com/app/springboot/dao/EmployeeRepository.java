package com.app.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.springboot.entity.Employee;

@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

// ### Pagination ### 
// http://localhost:8080/magic-api/members?page=0&size=3
// http://localhost:8080/magic-api/members?page=1&siz

// ### Sorting ###  [ Bye Default sorting type : ASC ]
// Sort by last name [ASC] : http://localhost:8080/magic-api/members?sort=lastName
// Sort by last name [DESC] : http://localhost:8080/magic-api/members?sort=lastName,firstName,desc
// Sort by name [DESC] : http://localhost:8080/magic-api/members?sort=lastName,firstName,desc
	
	