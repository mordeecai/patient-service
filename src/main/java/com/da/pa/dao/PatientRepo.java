package com.da.pa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.da.pa.model.Patient;

public interface PatientRepo extends CrudRepository<Patient, Long> {
	
	@Query(value = "SELECT p FROM Patient p WHERE p.active = ?1 ORDER BY p.firstName, p.lastName")
	List<Patient> findByStatus(boolean active);
	
	@Query(value = "SELECT p FROM Patient p, Address a WHERE p.id = a.id "
			+ " AND (p.firstName LIKE %?1% "
			+ " OR p.lastName LIKE %?1%"
			+ " OR a.country = ?1)"
			+ " ORDER BY p.firstName, p.lastName ASC")
	List<Patient> findByQueryString(String query);
	
	@Query(value = "SELECT p FROM Patient p, Address a WHERE p.id = ?1")
	Optional<Patient> findById(Long id);

}
