package com.app.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.clinicals.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
