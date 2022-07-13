package com.nitjsr.entities;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Insurance {

	private String providerName;
	private double copay;

}
