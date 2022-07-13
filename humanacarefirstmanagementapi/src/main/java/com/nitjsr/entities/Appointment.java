package com.nitjsr.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "APPOINTMENT")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Timestamp appointmentTime;
	private boolean started;
	private boolean ended;
	private String reason;
	
	@ManyToOne
	private Patient patient;
	
	@ManyToOne
	private Doctor doctor;

}
