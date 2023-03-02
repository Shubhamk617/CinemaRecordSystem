/**
 * 
 */
package com.cinemarecords.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cinemarecords.model.Actor;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName ActorServices.java
 * @Description
 */
@Component
public interface ActorServices {

	public Actor saveActor(Actor actor);

	public List<Actor> getActors();

	public Optional<Actor> getActorById(int actorId);

	public void updateActor(Actor actor);

	public void deleteActor(Actor actor);

	public void deleteActorById(int actorId);

}
