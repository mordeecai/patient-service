package com.da.pa.service;

import java.util.List;

import com.da.pa.model.Patient;

public interface PatientService {
	public List<Patient> getPatients();
	
	public List<Patient> getPatients(String searchQuery);
	
	public Patient getPatientById(Long id);
	
	public void createPatient(Patient patient);
	
	public void updatePatient(Patient patient);
	
	public void deletePatient(Patient patient);

}
