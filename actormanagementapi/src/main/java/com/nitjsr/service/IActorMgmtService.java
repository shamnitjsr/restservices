package com.nitjsr.service;

import java.util.List;

import com.nitjsr.model.Actor;

public interface IActorMgmtService {
	
	String registerActor(Actor actor);
	public Iterable<Actor> getAllActors();
	public Actor getActorById(int id);
	
	public List<Actor> fetchActorsByCategory(String category1, String category2);

}
