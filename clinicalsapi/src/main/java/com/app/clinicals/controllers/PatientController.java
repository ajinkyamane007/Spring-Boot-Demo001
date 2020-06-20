package com.app.clinicals.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.clinicals.model.ClinicalData;
import com.app.clinicals.model.Patient;
import com.app.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class PatientController {

	private PatientRepository repository;
	
	@Autowired  //Ctor level dependency injected
	PatientController(PatientRepository repository){
		this.repository=repository;
	}
	
	@RequestMapping(value = "/patients",method = RequestMethod.GET)
	public List<Patient> getPatients() {
		return repository.findAll();
	}
	
	@RequestMapping(value = "/patients/{id}",method = RequestMethod.GET)
	public Patient getPatient(@PathVariable("id") int id) { //@PathVariable : Fetch id from url 
		return repository.findById(id).get();	
	}
	
	@RequestMapping(value = "/patients",method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient) { //@RequestBody : To deserialize JSON obj                                  
		return repository.save(patient);
		
	}
	
	@RequestMapping(value = "/patients/analyze/{id}",method = RequestMethod.GET)
	public Patient analyaze(@PathVariable ("id") int id) {
		Patient patient=repository.findById(id).get();
		List<ClinicalData>clinicalData=patient.getClinicalData();
		ArrayList<ClinicalData>duplicateClinicalData=new ArrayList<>(clinicalData);
	
		for (ClinicalData eachEntry : duplicateClinicalData) 
		{
			if(eachEntry.getComponentName().equals("hw"))
			{
				String[] heightAndWeight=eachEntry.getComponentValue().split("/");
				if(heightAndWeight != null && heightAndWeight.length > 1)
				{
					float heightInMeter=Float.parseFloat(heightAndWeight[0])*0.4536F;
					float bmi=Float.parseFloat(heightAndWeight[1])/(heightInMeter*heightInMeter);
					ClinicalData bmiData=new ClinicalData();
					bmiData.setComponentName("bmi");
					bmiData.setComponentValue(Float.toString(bmi));
					clinicalData.add(bmiData);
				}

			}
		 }
		return patient;
	}
	
}
