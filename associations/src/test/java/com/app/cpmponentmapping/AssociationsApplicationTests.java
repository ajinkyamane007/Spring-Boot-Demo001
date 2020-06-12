package com.app.cpmponentmapping;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.cpmponentmapping.onetomany.entities.Customer;
import com.app.cpmponentmapping.onetomany.entities.PhoneNumber;
import com.app.cpmponentmapping.onetomany.repos.CustomerRepository;

@SpringBootTest
class AssociationsApplicationTests 
{
	@Autowired
	CustomerRepository repository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		Customer cus=new Customer();
		cus.setName("Sumit");
	//	HashSet<PhoneNumber>numbers=new HashSet<PhoneNumber>();
		
		PhoneNumber ph1=new PhoneNumber();
		ph1.setNumber("9922674445");
		ph1.setType("cell");
	//	ph1.setCustomer(cus);
	//	numbers.add(ph1);
		
		PhoneNumber ph2=new PhoneNumber();
		ph2.setNumber("7743674445");
		ph2.setType("cell");
	//	ph2.setCustomer(cus);
	//	numbers.add(ph2);
		
	//	cus.setNumbers(numbers);
		
		cus.addPhoneNumber(ph1);
		cus.addPhoneNumber(ph1);
		
		repository.save(cus);
		
	} 

}
