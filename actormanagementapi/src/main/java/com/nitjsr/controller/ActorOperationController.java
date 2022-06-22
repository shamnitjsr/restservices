package com.nitjsr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nitjsr.model.Actor;
import com.nitjsr.service.IActorMgmtService;

@RestController
@RequestMapping("/actor/api")
public class ActorOperationController {

	@Autowired
	private IActorMgmtService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveActor(@RequestBody Actor actor){
		
		try {
			//use service
			String msg = service.registerActor(actor);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED); //201 created 
			
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
