package com.app.hybernateinheritance;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.hybernateinheritance.entiries.Check;
import com.app.hybernateinheritance.entiries.CreditCard;
import com.app.hybernateinheritance.repos.PaymentRepository;

@SpringBootTest
class HybernateinheritanceApplicationTests {

	@Autowired
	PaymentRepository repository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void createPayment() 
	{
		CreditCard cc=new CreditCard();
		cc.setId(105);
		cc.setAmount(10000);
		cc.setCardnumber("1234567890");
		repository.save(cc);
	} 
	
	@Test
	void createCheckPayment() 
	{
		Check ch=new Check();
		ch.setId(106);
		ch.setAmount(10000);
		ch.setChecknumber("1234567890");
		repository.save(ch);
	} 

}
