package com.app.transactionalmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.app.transactionalmanagement.entities.BanckAccount;

public interface BanckAccountRepository extends CrudRepository<BanckAccount, Integer> {

}
