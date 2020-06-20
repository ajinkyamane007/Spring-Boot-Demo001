package com.app.transactionalmanagement.services;

import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.transactionalmanagement.entities.BanckAccount;
import com.app.transactionalmanagement.repos.BanckAccountRepository;

@Service
public class BanckAccountServiceImpl implements BanckAccountService {

	@Autowired
	BanckAccountRepository repository;

	@Override
	@Transactional  // To rollback transaction when out of two at least one transaction if fail
	public void transfer(int amount) {
		Optional<BanckAccount> acccount1 = repository.findById(1);
		if (acccount1.isPresent()) {
			BanckAccount acc1 = acccount1.get();
			acc1.setBal(acc1.getBal() - amount);
			repository.save(acc1);
		}
		
		//if(true) {
		//throw new RuntimeErrorException(null);
		//}
		
		Optional<BanckAccount> acccount2 = repository.findById(2);
		if (acccount2.isPresent()) {
			BanckAccount acc2 = acccount2.get();
			acc2.setBal(acc2.getBal() + amount);
			repository.save(acc2);
		}
	}

}

//Optional<BanckAccount> acccount1=repository.findById(1);
//acccount1.get().setBal( acccount1.get().getBal() - amount );
//repository.save(acccount1.get());
//
//Optional<BanckAccount> acccount2=repository.findById(1);
//acccount2.get().setBal( acccount2.get().getBal() + amount );
//repository.save(acccount2.get());