package com.app.jpqlandnativesql.entities.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.app.jpqlandnativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student>findAllStudents();
	
	@Query("select s.firstName,s.lastName from Student s")
	List<Object[]>findAllStudentsPartialData();
}
