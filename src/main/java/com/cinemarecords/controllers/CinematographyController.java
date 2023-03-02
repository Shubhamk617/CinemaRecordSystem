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

import com.cinemarecords.exceptions.CinematographyNotFoundException;
import com.cinemarecords.model.Cinematography;
import com.cinemarecords.service.CinematographyServices;

import jakarta.validation.Valid;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName CinematographyController.java
 * @Description
 */
@RestController
@RequestMapping("/cinematography")
public class CinematographyController {

	@Autowired
	CinematographyServices cinematographyServices;

	/*
	 * @GetMapping("/getAllCinematographysWithHateoas") private
	 * CollectionModel<Cinematography> getAllCinematographysWithHateoas() { // TODO
	 * Auto-generated method stub List<Cinematography> cinematographys =
	 * cinematographyServices.getCinematographys();
	 * cinematographys.forEach(cinematography -> { Link withSelfRel =
	 * linkTo(methodOn(CinematographyController.class).getCinematographyById(
	 * cinematography. getCinematographyId())). withSelfRel();
	 * cinematography.add(withSelfRel); }); return
	 * CollectionModel.of(cinematographys); }
	 */

	@GetMapping("/getAllCinematographys")
	private List<Cinematography> getAllCinematographys() {
		// TODO Auto-generated method stub
		return cinematographyServices.getCinematographys();
	}

	@GetMapping("/getCinematographyById")
	private Optional<Cinematography> getCinematographyById(@RequestParam int cinematographyId) {
		// TODO Auto-generated method stub
		Optional<Cinematography> cinematography = cinematographyServices.getCinematographyById(cinematographyId);

		if (cinematography.isEmpty())
			throw new CinematographyNotFoundException(
					"Cinematography with ID:" + cinematographyId + " does not exist.");

		return cinematography;

	}
	/*
	 * @GetMapping("/getMovieCinematographyByDId") private Movie
	 * getMovieCinematographyByDId(@RequestParam int cinematographyId) { // TODO
	 * Auto-generated method stub Optional<Cinematography> cinematography =
	 * cinematographyServices.getCinematographyById(cinematographyId);
	 * 
	 * if (cinematography.isEmpty()) throw new
	 * CinematographyNotFoundException("Cinematography with ID:" + cinematographyId
	 * + " does not exist.");
	 * 
	 * return cinematography.get().getMovie();
	 * 
	 * }
	 */

	@DeleteMapping("/deleteCinematographysById")
	private void deleteCinematographysById(@RequestParam List<String> cinematographyId) {
		// TODO Auto-generated method stub
		cinematographyId.forEach(dId -> {
			Optional<Cinematography> cinematography = cinematographyServices
					.getCinematographyById(Integer.valueOf(dId));
			if (cinematography.isEmpty())
				throw new CinematographyNotFoundException(
						"Cinematography with ID:" + cinematographyId + " does not exist.");
			cinematographyServices.deleteCinematographyById(Integer.valueOf(dId));
		});
	}

	@GetMapping("/getCinematographyByIdPathVar/{cinematographyId}")
	private Optional<Cinematography> getCinematographyByIdPathVar(@PathVariable int cinematographyId) {
		// TODO Auto-generated method stub
		Optional<Cinematography> cinematography = cinematographyServices.getCinematographyById(cinematographyId);

		if (cinematography.isEmpty())
			throw new CinematographyNotFoundException(
					"Cinematography with ID:" + cinematographyId + " does not exist.");

		return cinematography;
	}

	@PostMapping("/saveCinematography")
	private ResponseEntity<Cinematography> saveCinematography(@Valid @RequestBody Cinematography cinematography) {
		// TODO Auto-generated method stub
		Cinematography savedCinematography = cinematographyServices.saveCinematography(cinematography);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCinematography.getCinematographyId()).toUri();
		return ResponseEntity.created(location).build();
		// cinematographyServices.saveCinematography(cinematography);
	}

	@PostMapping("/saveAllCinematographys")
	private void saveAllCinematographys(@RequestBody List<Cinematography> cinematography) {
		// TODO Auto-generated method stub
		cinematography.forEach(currCinematography -> {
			Optional<Cinematography> existingCinematography = cinematographyServices
					.getCinematographyById(currCinematography.getCinematographyId());
			if (existingCinematography.isPresent())
				cinematographyServices.saveCinematography(currCinematography);
			cinematographyServices.saveCinematography(currCinematography);
		});
	}

	@PutMapping("/updateCinematography")
	private void updateCinematography(@RequestBody Cinematography cinematography) {
		// TODO Auto-generated method stub
		Optional<Cinematography> existingCinematography = cinematographyServices
				.getCinematographyById(cinematography.getCinematographyId());
		if (existingCinematography.isEmpty())
			throw new CinematographyNotFoundException(
					"Cinematography with ID:" + cinematography.getCinematographyId() + " does not exist.");

		cinematographyServices.saveCinematography(cinematography);
	}

	@DeleteMapping("/deleteCinematography")
	private void deleteCinematography(@RequestBody Cinematography cinematography) {
		// TODO Auto-generated method stub
		Optional<Cinematography> existingCinematography = cinematographyServices
				.getCinematographyById(cinematography.getCinematographyId());
		if (existingCinematography.isEmpty())
			throw new CinematographyNotFoundException(
					"Cinematography with ID:" + cinematography.getCinematographyId() + " does not exist.");
		cinematographyServices.deleteCinematography(cinematography);
	}

	@DeleteMapping("/deleteCinematographyById")
	private void deleteCinematography(@RequestParam int cinematographyId) {
		// TODO Auto-generated method stub
		Optional<Cinematography> existingCinematography = cinematographyServices
				.getCinematographyById(cinematographyId);
		if (existingCinematography.isEmpty())
			throw new CinematographyNotFoundException(
					"Cinematography with ID:" + cinematographyId + " does not exist.");
		cinematographyServices.deleteCinematographyById(cinematographyId);
	}

}
