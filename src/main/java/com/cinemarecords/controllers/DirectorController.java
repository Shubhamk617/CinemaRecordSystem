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

import com.cinemarecords.exceptions.DirectorNotFoundException;
import com.cinemarecords.model.Director;
import com.cinemarecords.model.Movie;
import com.cinemarecords.service.DirectorServices;

import jakarta.validation.Valid;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName DirectorController.java
 * @Description
 */
@RestController
@RequestMapping("/director")
public class DirectorController {

	@Autowired
	DirectorServices directorServices;

	/*
	 * @GetMapping("/getAllDirectorsWithHateoas") private CollectionModel<Director>
	 * getAllDirectorsWithHateoas() { // TODO Auto-generated method stub
	 * List<Director> directors = directorServices.getDirectors();
	 * directors.forEach(director -> { Link withSelfRel =
	 * linkTo(methodOn(DirectorController.class).getDirectorById(director.
	 * getDirectorId())). withSelfRel(); director.add(withSelfRel); }); return
	 * CollectionModel.of(directors); }
	 */

	@GetMapping("/getAllDirectors")
	private List<Director> getAllDirectors() {
		// TODO Auto-generated method stub
		return directorServices.getDirectors();
	}

	@GetMapping("/getDirectorById")
	private Optional<Director> getDirectorById(@RequestParam int directorId) {
		// TODO Auto-generated method stub
		Optional<Director> director = directorServices.getDirectorById(directorId);

		if (director.isEmpty())
			throw new DirectorNotFoundException("Director with ID:" + directorId + " does not exist.");

		return director;

	}
	
	@GetMapping("/getMovieDirectorByDId")
	private Movie getMovieDirectorByDId(@RequestParam int directorId) {
		// TODO Auto-generated method stub
		Optional<Director> director = directorServices.getDirectorById(directorId);

		if (director.isEmpty())
			throw new DirectorNotFoundException("Director with ID:" + directorId + " does not exist.");

		return director.get().getMovie();

	}

	@DeleteMapping("/deleteDirectorsById")
	private void deleteDirectorsById(@RequestParam List<String> directorId) {
		// TODO Auto-generated method stub
		directorId.forEach(dId -> {
			Optional<Director> director = directorServices.getDirectorById(Integer.valueOf(dId));
			if (director.isEmpty())
				throw new DirectorNotFoundException("Director with ID:" + directorId + " does not exist.");
			directorServices.deleteDirectorById(Integer.valueOf(dId));
		});
	}

	@GetMapping("/getDirectorByIdPathVar/{directorId}")
	private Optional<Director> getDirectorByIdPathVar(@PathVariable int directorId) {
		// TODO Auto-generated method stub
		Optional<Director> director = directorServices.getDirectorById(directorId);

		if (director.isEmpty())
			throw new DirectorNotFoundException("Director with ID:" + directorId + " does not exist.");

		return director;
	}

	@PostMapping("/saveDirector")
	private ResponseEntity<Director> saveDirector(@Valid @RequestBody Director director) {
		// TODO Auto-generated method stub
		Director savedDirector = directorServices.saveDirector(director);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDirector.getDirectorId()).toUri();
		return ResponseEntity.created(location).build();
		// directorServices.saveDirector(director);
	}

	@PutMapping("/updateDirector")
	private void updateDirector(@RequestBody Director director) {
		// TODO Auto-generated method stub
		Optional<Director> existingDirector = directorServices.getDirectorById(director.getDirectorId());
		if (existingDirector.isEmpty())
			throw new DirectorNotFoundException("Director with ID:" + director.getDirectorId() + " does not exist.");

		directorServices.saveDirector(director);
	}

	@DeleteMapping("/deleteDirector")
	private void deleteDirector(@RequestBody Director director) {
		// TODO Auto-generated method stub
		Optional<Director> existingDirector = directorServices.getDirectorById(director.getDirectorId());
		if (existingDirector.isEmpty())
			throw new DirectorNotFoundException("Director with ID:" + director.getDirectorId() + " does not exist.");
		directorServices.deleteDirector(director);
	}

	@DeleteMapping("/deleteDirectorById")
	private void deleteDirector(@RequestParam int directorId) {
		// TODO Auto-generated method stub
		Optional<Director> existingDirector = directorServices.getDirectorById(directorId);
		if (existingDirector.isEmpty())
			throw new DirectorNotFoundException("Director with ID:" + directorId + " does not exist.");
		directorServices.deleteDirectorById(directorId);
	}

}
