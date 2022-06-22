package com.nitjsr.service;

import com.nitjsr.model.Actor;

public interface IActorMgmtService {
	
	String registerActor(Actor actor);
	public Iterable<Actor> getAllActors();
	public Actor getActorById(int id);

}
