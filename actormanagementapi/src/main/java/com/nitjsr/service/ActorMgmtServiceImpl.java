package com.nitjsr.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitjsr.model.Actor;
import com.nitjsr.repository.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService {

	@Autowired
	private IActorRepo actorRepo;

	@Override
	public String registerActor(Actor actor) {

		Actor actorS = actorRepo.save(actor);
		return "Actor is registered with id Value" + actorS.getActorid();
	}

	@Override

	public Iterable<Actor> getAllActors() {
		Iterable<Actor> it = actorRepo.findAll();
		List<Actor> list1 = (List<Actor>) it;
		list1.sort((t1, t2) -> t1.getActorname().compareTo(t2.getActorname()));
		return list1;
	}

	/*
	 * @Override public Iterable<Actor> getAllActors(){ Iterable<Actor>
	 * it=actorRepo.findAll();
	 * Collections.sort((List<Actor>)it,(t1,t2)->t1.getActorname().compareTo(t2.
	 * getActorname())); return it; }
	 */

	/*
	 * @Override public Iterable<Actor> getAllActors() { Iterable<Actor> it =
	 * actorRepo.findAll(); List<Actor> list1 =
	 * StreamSupport.stream(it.spliterator(), false) .sorted((t1, t2) ->
	 * t1.getActorname().compareTo(t2.getActorname())).collect(Collectors.toList());
	 * return list1; }
	 */
}
