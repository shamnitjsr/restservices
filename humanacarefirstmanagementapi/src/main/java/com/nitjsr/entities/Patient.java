package com.nitjsr.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	@Embedded
	private Insurance insurance;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="PATIENTS_DOCTORS" , joinColumns = @JoinColumn(name="patient_id", referencedColumnName="id"),
	inverseJoinColumns  = @JoinColumn(name = "doctor_id", referencedColumnName = "id"))
	private List<Doctor> doctors;
	
	@OneToMany
	List<Appointment> appintments;

}
