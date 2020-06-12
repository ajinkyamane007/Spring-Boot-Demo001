package com.app.cpmponentmapping.onetomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.app.cpmponentmapping.onetomany.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
