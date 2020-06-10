package com.app.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

		repository.save(student);
		repository.save(student2);
	}

	@Test
	public void testFindAllStudents() {
		System.out.println(repository.findAllStudents());
	}

	@Test
	public void testFindAllStudentsPartialData() {
		List<Object[]> partialData = repository.findAllStudentsPartialData();
		//use foreach iterator to fetch data here
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);
		}

	}
}
