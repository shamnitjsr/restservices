package com.nitjsr.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Patient {

	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	private Insurance insurance;

}
