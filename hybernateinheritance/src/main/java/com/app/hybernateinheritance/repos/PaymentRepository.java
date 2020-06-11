package com.app.hybernateinheritance.repos;

import org.springframework.data.repository.CrudRepository;

import com.app.hybernateinheritance.entiries.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
