package com.nitjsr;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nitjsr.entities.Appointment;
import com.nitjsr.entities.Doctor;
import com.nitjsr.entities.Insurance;
import com.nitjsr.entities.Patient;
import com.nitjsr.repository.AppointmentRepository;
import com.nitjsr.repository.DoctorRepository;
import com.nitjsr.repository.PatientRepository;

@SpringBootTest
class HumanacarefirstmanagementapiApplicationTests {

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	AppointmentRepository appointmentRepository;

	@Test
	public void testCreateDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("Shambhu");
		doctor.setLastName("Kumar");
		doctor.setSpeciality("All");
		doctorRepository.save(doctor);
	}

	@Test
	public void testCreatePatient() {

		Patient patient = new Patient();
		patient.setFirstName("SHIV KUMAR");
		patient.setLastName("RAJAN");
		patient.setPhone("9999999999");

		Insurance insurance = new Insurance();
		insurance.setProviderName("Blue Cross Blue Shield");
		insurance.setCopay(20d);

		patient.setInsurance(insurance);

		Optional<Doctor> doctor = doctorRepository.findById(1L);
		List<Doctor> doctors = Arrays.asList(doctor);
		patient.setDoctors(doctors);

		patientRepository.save(patient);
	}

	@Test
	public void testCreateAppointment() {
		Appointment appointment = new Appointment();
		Timestamp appointmentTime = new Timestamp(new Date().getTime());
		appointment.setAppointmentTime(appointmentTime);
		appointment.setReason("I have a problem");
		appointment.setStarted(true);

		appointment.setPatient(patientRepository.findById(1l));
		appointment.setDoctor(doctorRepository.findById(1l));

		appointmentRepository.save(appointment);
	}

}
