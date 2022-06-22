package com.nitjsr.repository;

import org.springframework.data.repository.CrudRepository;

import com.nitjsr.model.Actor;

public interface IActorRepo extends CrudRepository<Actor, Integer>{

}
