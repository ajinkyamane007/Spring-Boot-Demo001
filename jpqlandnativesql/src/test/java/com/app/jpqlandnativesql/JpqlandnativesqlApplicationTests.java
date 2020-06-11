package com.app.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.app.jpqlandnativesql.entities.Student;
import com.app.jpqlandnativesql.entities.repos.StudentRepository;

@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	// Table 'mydb.hibernate_sequence' doesn't exist

	@Test
	void testStudentCreate() {
		Student student = new Student();
		student.setLastName("Mane");
		student.setFirstName("Ajinkya");
		student.setScore(92);

		Student student2 = new Student();
		student2.setLastName("Sayanker");
		student2.setFirstName("Suyesh");
		student2.setScore(95);
		
		Student student3 = new Student();
		student3.setLastName("Mane");
		student3.setFirstName("Ajinkya");
		student3.setScore(92);

		Student student4 = new Student();
		student4.setLastName("Sayanker");
		student4.setFirstName("Suyesh");
		student4.setScore(95);

		repository.save(student);
		repository.save(student2);
		repository.save(student3);
		repository.save(student4);
	}

//	@Test
//	public void testFindAllStudents() {
//		System.out.println(repository.findAllStudents());
//	}
	
   // =============== Paging & Sorting ============================
	@Test
	public void testFindAllStudents() {
		System.out.println(repository.findAllStudents(PageRequest.of(1, 4)));
		//System.out.println(repository.findAllStudents(PageRequest.of(1, 4, Sort.by(Direction.DESC, "score"))));
		//System.out.println(repository.findAllStudents(PageRequest.of(0, 4, Direction.DESC, "lastName")));

	}	

	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		//use foreach iterator to fetch data here
		for (Object[] objects : partialData)
		{
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}
	}
	
	@Test
	public void testfindAllStudentsByfirstName() {
		System.out.println(repository.findAllStudentsByfirstName("Ajinkya"));
	}
	
	@Test
	public void testfindAllStudentForGivenScore() {
		System.out.println(repository.findAllStudentForGivenScore(80, 98));
	}
	
	@Test
	@Transactional //from spring DML operation
	@Rollback(false)
	public void testdeleteStudentByfirstName() {
		repository.deleteStudentByfirstName("Suyesh");
	}
}
