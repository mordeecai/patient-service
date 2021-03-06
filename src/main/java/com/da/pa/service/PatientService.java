package com.da.pa.service;

import java.util.List;

import com.da.pa.model.Patient;

public interface PatientService {
	public List<Patient> getPatients();
	
	public List<Patient> getPatients(String searchQuery);
	
	public Patient getPatientById(Long id);
	
	public Patient createPatient(Patient patient);
	
	public Patient updatePatient(Patient patient);
	
	public void deletePatient(Patient patient);

}
