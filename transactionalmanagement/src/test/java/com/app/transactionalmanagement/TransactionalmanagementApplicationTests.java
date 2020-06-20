package com.app.transactionalmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.app.transactionalmanagement.services.BanckAccountService;

@SpringBootTest
class TransactionalmanagementApplicationTests {

	@Autowired
	BanckAccountService service;
	
	@Test
//	@Transactional
//	@Rollback(false)
	void testTransfer() {
		service.transfer(500);
	}

}
