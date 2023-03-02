/**
 * 
 */
package com.cinemarecords.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinemarecords.dao.ActorRepository;
import com.cinemarecords.model.Actor;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName ActorServicesImpl.java
 * @Description
 */
@Component
public class ActorServicesImpl implements ActorServices {

	@Autowired
	ActorRepository actorRepository;

	@Override
	public Actor saveActor(Actor actor) {
		// TODO Auto-generated method stub
		return actorRepository.save(actor);
	}

	@Override
	public List<Actor> getActors() {
		// TODO Auto-generated method stub
		return actorRepository.findAll();
	}

	@Override
	public Optional<Actor> getActorById(int actorId) {
		// TODO Auto-generated method stub
		return actorRepository.findById(actorId);
	}

	@Override
	public void updateActor(Actor actor) {
		// TODO Auto-generated method stub
		actorRepository.save(actor);

	}

	@Override
	public void deleteActor(Actor actor) {
		// TODO Auto-generated method stub
		actorRepository.delete(actor);

	}

	@Override
	public void deleteActorById(int actorId) {
		// TODO Auto-generated method stub
		actorRepository.deleteById(actorId);
	}

}
