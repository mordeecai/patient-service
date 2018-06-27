package com.da.pa.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.log4j.Logger;

import com.da.pa.dao.AddressRepo;
import com.da.pa.dao.PatientRepo;
import com.da.pa.model.Address;
import com.da.pa.model.Patient;
import com.da.pa.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	
	private static final Logger log = Logger.getLogger(PatientServiceImpl.class);
	
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
		try {
			return (List<Patient>) repo.findByQueryString(searchQuery);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return new ArrayList<Patient>();
	}

	@Override
	public Patient createPatient(Patient patient) {
		try {
			return repo.save(patient);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
		
	}

	@Override
	public Patient updatePatient(Patient patient) {
		try {
			Patient old = getPatientById(patient.getId());
			List<Address> addresses = old.getAddresses();
			addresses.forEach(a -> addRepo.delete(a));		
			return repo.save(patient);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;		
	}

	@Override
	public void deletePatient(Patient patient) {
		try {
			repo.delete(patient);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public Patient getPatientById(Long id) {
		try {
			Optional<Patient> patient = repo.findById(id); 
			return (patient.isPresent()) ? patient.get() : null;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return null;
	}

}
