package com.app.cpmponentmapping;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.app.cpmponentmapping.manytomany.entities.Programmer;
import com.app.cpmponentmapping.manytomany.entities.Project;
import com.app.cpmponentmapping.manytomany.repos.ProgrammerRepository;
import com.app.cpmponentmapping.onetomany.entities.Customer;
import com.app.cpmponentmapping.onetomany.entities.PhoneNumber;
import com.app.cpmponentmapping.onetomany.repos.CustomerRepository;
import com.app.cpmponentmapping.onetoone.entities.License;
import com.app.cpmponentmapping.onetoone.entities.Person;
import com.app.cpmponentmapping.onetoone.repos.LicenseRepository;

@SpringBootTest
class AssociationsApplicationTests 
{
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	ProgrammerRepository programmerRepository;
	
	@Autowired
	LicenseRepository licenserepository;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateCustomer() {
		Customer cus=new Customer();
		cus.setName("Adity");
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
		Optional<Customer> cus =repository.findById(6L);
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
		Optional<Customer> cus =repository.findById(6L);
		if (cus.isPresent())
		{
			Customer customer=cus.get();
			customer.setName("Abhijeet Mane");
			
			Set<PhoneNumber>numbers=customer.getNumbers();
			numbers.forEach(number->number.setType("cell"));
		}	
	}
	
	@Test
	@Transactional
	public void testDeleteCustomer() {
		repository.deleteById(6l);
	}
	
	@Test
	public void testmtomCreatedProgrammer()
	{
		Programmer programmer=new Programmer();
		programmer.setName("Arjun");
		programmer.setSal(55000);
		
		HashSet<Project>projects=new HashSet<Project>();
		Project project=new Project();
		project.setName("Hibernate Project");
		projects.add(project);
		
		programmer.setProjects(projects);
		programmerRepository.save(programmer);
	}
	
	@Test
	@Transactional   // To remove lazyinitialization exception its mandatory
	public void testmtomFindProgrammer()
	{
		Optional<Programmer> programmer=programmerRepository.findById(1);
		if (programmer.isPresent())
		{
			Programmer Pro=programmer.get();
			System.out.println(Pro);
			System.out.println(Pro.getProjects());

		}
	}
	
	@Test
	public void testonetooneCreatedLicence()
	{
		License license=new License();
		license.setType("car");
		license.setValidFrom(new Date());
		license.setValidTo(new Date());
		
		Person person=new Person();
		person.setFirstName("Ajinkya");
		person.setLastName("Mane");
		person.setAge(24);
		
		license.setPerson(person);
		
		licenserepository.save(license);
	}

}
