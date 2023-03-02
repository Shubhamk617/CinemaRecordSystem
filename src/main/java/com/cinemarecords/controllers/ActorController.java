/**
 * 
 */
package com.cinemarecords.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemarecords.exceptions.ActorNotFoundException;
import com.cinemarecords.model.Actor;
import com.cinemarecords.model.Movie;
import com.cinemarecords.service.ActorServices;

import jakarta.validation.Valid;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName ActorController.java
 * @Description
 */
@RestController
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	ActorServices actorServices;

	/*
	 * @GetMapping("/getAllActorsWithHateoas") private CollectionModel<Actor>
	 * getAllActorsWithHateoas() { // TODO Auto-generated method stub List<Actor>
	 * actors = actorServices.getActors(); actors.forEach(actor -> { Link
	 * withSelfRel = linkTo(methodOn(ActorController.class).getActorById(actor.
	 * getActorId())). withSelfRel(); actor.add(withSelfRel); }); return
	 * CollectionModel.of(actors); }
	 */

	@GetMapping("/getAllActors")
	private List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return actorServices.getActors();
	}

	@GetMapping("/getActorById")
	private Optional<Actor> getActorById(@RequestParam int actorId) {
		// TODO Auto-generated method stub
		Optional<Actor> actor = actorServices.getActorById(actorId);

		if (actor.isEmpty())
			throw new ActorNotFoundException("Actor with ID:" + actorId + " does not exist.");

		return actor;

	}
	/*
	 * @GetMapping("/getMovieActorByDId") private Movie
	 * getMovieActorByDId(@RequestParam int actorId) { // TODO Auto-generated method
	 * stub Optional<Actor> actor = actorServices.getActorById(actorId);
	 * 
	 * if (actor.isEmpty()) throw new ActorNotFoundException("Actor with ID:" +
	 * actorId + " does not exist.");
	 * 
	 * return actor.get().getMovie();
	 * 
	 * }
	 */

	@DeleteMapping("/deleteActorsById")
	private void deleteActorsById(@RequestParam List<String> actorId) {
		// TODO Auto-generated method stub
		actorId.forEach(dId -> {
			Optional<Actor> actor = actorServices.getActorById(Integer.valueOf(dId));
			if (actor.isEmpty())
				throw new ActorNotFoundException("Actor with ID:" + actorId + " does not exist.");
			actorServices.deleteActorById(Integer.valueOf(dId));
		});
	}

	@GetMapping("/getActorByIdPathVar/{actorId}")
	private Optional<Actor> getActorByIdPathVar(@PathVariable int actorId) {
		// TODO Auto-generated method stub
		Optional<Actor> actor = actorServices.getActorById(actorId);

		if (actor.isEmpty())
			throw new ActorNotFoundException("Actor with ID:" + actorId + " does not exist.");

		return actor;
	}

	@PostMapping("/saveActor")
	private ResponseEntity<Actor> saveActor(@Valid @RequestBody Actor actor) {
		// TODO Auto-generated method stub
		Actor savedActor = actorServices.saveActor(actor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedActor.getActorId()).toUri();
		return ResponseEntity.created(location).build();
		// actorServices.saveActor(actor);
	}

	@PostMapping("/saveAllActors")
	private void saveAllActors(@RequestBody List<Actor> actor) {
		// TODO Auto-generated method stub
		actor.forEach(currActor -> {
			Optional<Actor> existingActor = actorServices.getActorById(currActor.getActorId());
			if (existingActor.isPresent())
				actorServices.saveActor(currActor);
			actorServices.saveActor(currActor);
		});
	}

	@PutMapping("/updateActor")
	private void updateActor(@RequestBody Actor actor) {
		// TODO Auto-generated method stub
		Optional<Actor> existingActor = actorServices.getActorById(actor.getActorId());
		if (existingActor.isEmpty())
			throw new ActorNotFoundException("Actor with ID:" + actor.getActorId() + " does not exist.");

		actorServices.saveActor(actor);
	}

	@DeleteMapping("/deleteActor")
	private void deleteActor(@RequestBody Actor actor) {
		// TODO Auto-generated method stub
		Optional<Actor> existingActor = actorServices.getActorById(actor.getActorId());
		if (existingActor.isEmpty())
			throw new ActorNotFoundException("Actor with ID:" + actor.getActorId() + " does not exist.");
		actorServices.deleteActor(actor);
	}

	@DeleteMapping("/deleteActorById")
	private void deleteActor(@RequestParam int actorId) {
		// TODO Auto-generated method stub
		Optional<Actor> existingActor = actorServices.getActorById(actorId);
		if (existingActor.isEmpty())
			throw new ActorNotFoundException("Actor with ID:" + actorId + " does not exist.");
		actorServices.deleteActorById(actorId);
	}

}
