package com.app.clinicals.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.clinicals.dto.ClinicalDataRequest;
import com.app.clinicals.model.ClinicalData;
import com.app.clinicals.model.Patient;
import com.app.clinicals.repos.ClinicalDataRepository;
import com.app.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {
	

	private ClinicalDataRepository clinicalDataRepository;
	private PatientRepository patientRepository;
	
	ClinicalDataController(ClinicalDataRepository clinicalDataRepository,PatientRepository patientRepository){
		this.clinicalDataRepository=clinicalDataRepository;
		this.patientRepository=patientRepository;
	}
	
	@RequestMapping(value = "/clinicals",method = RequestMethod.POST)
	public ClinicalData saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient=patientRepository.findById(request.getPatientid()).get();
		
		ClinicalData clinicalData=new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);
		
	}
} 
