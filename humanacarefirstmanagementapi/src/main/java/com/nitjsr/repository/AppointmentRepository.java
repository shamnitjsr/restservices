package com.nitjsr.repository;

import org.springframework.data.repository.CrudRepository;

import com.nitjsr.entities.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

}
