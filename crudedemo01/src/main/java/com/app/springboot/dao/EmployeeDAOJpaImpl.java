package com.app.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.app.springboot.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager; // Field
	
	// Ctor level dependency injection
	public EmployeeDAOJpaImpl(EntityManager theEntityManager){
		entityManager=theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query theQuery=entityManager.createQuery("from Employee");
		List<Employee>employees=theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// Save or Update the Employee (SaveOrUpdate)
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		//update with id from db .. so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteByID(int theId) {
		// delete obj with primary key employeeId
		Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId ");
		theQuery.setParameter("employeeId",theId );
		theQuery.executeUpdate();
	}

}
