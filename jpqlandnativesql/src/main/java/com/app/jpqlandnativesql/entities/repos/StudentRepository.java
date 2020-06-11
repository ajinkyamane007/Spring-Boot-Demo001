package com.app.jpqlandnativesql.entities.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.app.jpqlandnativesql.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

//	@Query("from Student")
//	List<Student>findAllStudents();
	
	@Query("from Student")
	List<Student>findAllStudents(Pageable pageable);
	
	@Query("select s.firstName,s.lastName from Student s")
	List<Object[]>findAllStudentsPartialData();
	
	@Query("from Student where firstName =:fName")
	List<Student> findAllStudentsByfirstName(@Param("fName") String fName);
	
	@Query("from Student where score>:min and score<:max")
	List<Student> findAllStudentForGivenScore(@Param("min") int min,@Param("max") int max);
	
	@Modifying
	@Query("Delete from Student where firstName=:fName")
	void deleteStudentByfirstName(@Param("fName") String fName);
	
}
