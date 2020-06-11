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
	
	//JPQL paging & Sorting
	@Query("from Student")
	List<Student>findAllStudents(Pageable pageable);
	
	@Query("select s.firstName,s.lastName from Student s")
	//here instead of<Student> we get Object[] array of Student Obj
	List<Object[]>findAllStudentsPartialData();
	
	@Query("from Student where firstName =:fName")
	List<Student> findAllStudentsByfirstName(@Param("fName") String fName);
	
	@Query("from Student where score>:min and score<:max")
	List<Student> findAllStudentForGivenScore(@Param("min") int min,@Param("max") int max);
	
	@Modifying
	@Query("Delete from Student where firstName=:fName")
	void deleteStudentByfirstName(@Param("fName") String fName);
	
	// Native SQL Query
	@Query(value="select * from student",nativeQuery = true)
	//Table name is as  like in DB 'student' not 'Student' (i.e from Student.java)
	List<Student>findAllStudentsNQ();
	
	@Query(value="select * from student where fname=:fName",nativeQuery = true)
	// fname is check from DB  || =:fName is anything
	List<Student> findByfirstNameNQ(@Param("fName") String fName);
	
	@Query(value="select fname,score from student ",nativeQuery = true)
	//here instead of<Student> we get Object[] array of Student Obj
	List<Object[]>findPartialDataNQ();
	
//	@Query(value="select fname,score from student where score BETWEEN :min AND =:max",nativeQuery = true)
//	List<Student> findAllStudentForGivenScoreNQ(@Param("min") int min,@Param("max") int max);
	
//	@Modifying
//	@Query(value = "update student s set s.fname =:fName where s.score =:score", nativeQuery = true)
//	int updateUserSetStatusForNameNative( @Param("fName") String fName , @Param("score") int score );
	
}
