package com.app.transactionalmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.transactionalmanagement.services.BanckAccountService;

@SpringBootTest
class TransactionalmanagementApplicationTests {

	@Autowired
	BanckAccountService service;
	
	@Test
	void testTransfer() {
		service.transfer(500);
	}

}
