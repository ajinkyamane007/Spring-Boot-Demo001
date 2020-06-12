package com.app.cpmponentmapping;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
		cus.setName("Abhijeet");
	//	HashSet<PhoneNumber>numbers=new HashSet<PhoneNumber>();
		
		PhoneNumber ph1=new PhoneNumber();
		ph1.setNumber("9922674445");
		ph1.setType("cell");
	//	ph1.setCustomer(cus);
	//	numbers.add(ph1);
		
		PhoneNumber ph2=new PhoneNumber();
		ph2.setNumber("7743674445");
		ph2.setType("home");
	//	ph2.setCustomer(cus);
	//	numbers.add(ph2);
		
	//	cus.setNumbers(numbers);
		
		cus.addPhoneNumber(ph1);
		cus.addPhoneNumber(ph2);
		
		repository.save(cus);
		
	} 
	
	@Test
	@Transactional
	public void testLoadCustomer() {
		Optional<Customer> cus =repository.findById(5L);
		if (cus.isPresent())
		{
			Customer customer=cus.get();
			System.out.println(customer.getName());
			
			Set<PhoneNumber>numbers=customer.getNumbers();
			numbers.forEach(number->System.out.println(number.getNumber()));
		}	
	}
	
	@Test
	@Transactional
	public void testUpdateCustomer() {
		Optional<Customer> cus =repository.findById(5L);
		if (cus.isPresent())
		{
			Customer customer=cus.get();
			customer.setName("Abhijeet Mane");
			
			Set<PhoneNumber>numbers=customer.getNumbers();
			numbers.forEach(number->number.setType("cell"));
		}	
	}

}
