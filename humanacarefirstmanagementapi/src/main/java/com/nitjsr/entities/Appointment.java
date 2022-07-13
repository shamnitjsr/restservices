package com.nitjsr.entities;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Appointment {

	private Long id;
	private Timestamp appointmentTime;
	private boolean started;
	private boolean ended;
	private String reason;

}
