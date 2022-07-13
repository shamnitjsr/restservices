package com.nitjsr.repository;

import org.springframework.data.repository.CrudRepository;

import com.nitjsr.entities.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}
