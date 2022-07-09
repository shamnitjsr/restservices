package com.nitjsr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<String> saveActor(@RequestBody Actor actor) {

		// use service
		String msg = service.registerActor(actor);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED); // 201 created

	}

	@GetMapping("/findAll")
	public ResponseEntity<?> fetchAllActor() {

		Iterable<Actor> list = (List<Actor>) service.getAllActors();
		return new ResponseEntity<Iterable<Actor>>(list, HttpStatus.OK);

	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchActorId(@PathVariable int id) {

		Actor actor = service.getActorById(id);
		return new ResponseEntity<Actor>(actor, HttpStatus.OK);

	}

	@GetMapping("/actorinfo/{category1}/{category2}")
	public ResponseEntity<?> showActorsByCategories(@PathVariable String category1, @PathVariable String category2) {
		// use service

		List<Actor> list = service.fetchActorsByCategory(category1, category1);
		return new ResponseEntity<List<Actor>>(list, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyActor(@RequestBody Actor actor) {

		// use service
		String msg = service.updateActor(actor);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteActor(@PathVariable("id") int id) {

		// use service
		String msg = service.deleteActorById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@PatchMapping("/updateMobileNo/{id}/{newNo}") // partial update
	public ResponseEntity<String> changeActorMobileNo(@PathVariable("id") int id,
			@PathVariable("newNo") long newMobileNo) {

		// use service
		String msg = service.updateActorMobileNo(id, newMobileNo);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
