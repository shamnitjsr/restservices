package com.nitjsr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "REST_ACTOR")
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer actorid;
	
	@Column(length=20)
	private String actorname;
	
	@Column(length=20)
	private String category;
	private Long mobileNo;
}