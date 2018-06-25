package com.da.pa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.da.pa.dao.AddressRepo;
import com.da.pa.dao.PatientRepo;
import com.da.pa.model.Address;
import com.da.pa.model.Patient;
import com.da.pa.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepo repo;
	
	@Autowired
	AddressRepo addRepo;

	@Override
	public List<Patient> getPatients() {
		List<Patient> patients = new ArrayList<>();
		
		patients = (List<Patient>) repo.findAll();
		
		return patients;
	}

	@Override
	public List<Patient> getPatients(String searchQuery) {
		
		return (List<Patient>) repo.findByQueryString(searchQuery);
	}

	@Override
	public void createPatient(Patient patient) {
		repo.save(patient);
	}

	@Override
	public void updatePatient(Patient patient) {
		Patient old = getPatientById(patient.getId());
		List<Address> addresses = old.getAddresses();
		addresses.forEach(a -> addRepo.delete(a));		
		repo.save(patient);		
	}

	@Override
	public void deletePatient(Patient patient) {
		repo.delete(patient);
	}

	@Override
	public Patient getPatientById(Long id) {
		Optional<Patient> patient = repo.findById(id); 
		return (patient.isPresent()) ? patient.get() : null;
	}

}
