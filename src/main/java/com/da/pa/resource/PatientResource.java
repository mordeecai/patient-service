package com.da.pa.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.da.pa.model.Patient;
import com.da.pa.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientResource {
	
	@Autowired
	PatientService service;

	//Temporarily allowing any origins to call the API
	@CrossOrigin(origins = "*")
	@RequestMapping("")
	public String getService() {
		return "Welcome to Patient Service!";
	}

	//Temporarily allowing any origins to call the API
	@CrossOrigin(origins = "*")
	@RequestMapping(value="find", method= RequestMethod.GET, produces="application/json")
	public List<Patient> getPatientsByQuery(@RequestParam(required=false) String query) {
		List<Patient> patients = new ArrayList<>();
		
		if(query != null) {
			patients = service.getPatients(query);
		} else {
			patients = service.getPatients();
		}
		
		return patients;
	}

	//Temporarily allowing any origins to call the API
	@CrossOrigin(origins = "*")
	@RequestMapping(value="{id}", method= RequestMethod.GET, produces="application/json")
	public Patient getPatientsById(@PathVariable("id") String id) {
		Patient patient = new Patient();
		try {
			long pid = Long.parseLong(id);
			patient = service.getPatientById(Long.valueOf(pid));
		} catch (Exception e) {
			return new Patient();
		}
		
		return patient; 
	}

	//Temporarily allowing any origins to call the API
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "save", method = RequestMethod.POST, consumes="application/json")
	public void savePatient(@RequestBody Patient patient) {
		if(patient.getId() != null) {
			service.updatePatient(patient);
		} else {
			service.createPatient(patient);
		}
	}

	//Temporarily allowing any origins to call the API
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "countries", method = RequestMethod.GET, produces="application/json")
	public Map<String, String> getCountries() {
		String[] countryCodes = Locale.getISOCountries();
		Map<String, String> countries = new HashMap<>();

        for (String cc : countryCodes) {
        	countries.put(cc, new Locale("", cc).getDisplayCountry());
        }

        return countries;
	}
}
