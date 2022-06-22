package com.nitjsr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nitjsr.model.Actor;
import com.nitjsr.repository.IActorRepo;

@Service("actorMgmtService")
public class ActorMgmtServiceImpl implements IActorMgmtService{
	
	@Autowired
	private IActorRepo actorRepo;

	@Override
	public String registerActor(Actor actor) {
		
		Actor actorS = actorRepo.save(actor);
		return "Actor is registered with id Value" +actorS.getActorid();
	}

}
