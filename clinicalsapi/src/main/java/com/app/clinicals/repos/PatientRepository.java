package com.app.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
