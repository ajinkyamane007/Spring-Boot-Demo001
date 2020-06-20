package com.app.clinicals.dto;

import javax.persistence.Entity;

@Entity
public class ClinicalDataRequest {

	private String componentName;
	private String componentValue;
	private int patientid;
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentValue() {
		return componentValue;
	}
	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	
	
}
