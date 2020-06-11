package com.app.cpmponentmapping;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.cpmponentmapping.entities.Address;
import com.app.cpmponentmapping.entities.Employee;
import com.app.cpmponentmapping.repos.EmployeeRepository;

@SpringBootTest
class CopmponentmappingApplicationTests {

	@Autowired
	EmployeeRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreate(){
		Employee emp=new Employee();
		emp.setId(100);
		emp.setName("Ajinkya");
		Address addr=new Address();
		addr.setCity("Pune");
		addr.setStreetaddress("MG road");
		addr.setCountry("India");
		addr.setState("Maharashtra");
		addr.setZipcode("415406");
		emp.setAddress(addr);
		repository.save(emp);
	}


}
