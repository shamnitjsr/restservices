package com.nitjsr.repository;

import org.springframework.data.repository.CrudRepository;

import com.nitjsr.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
