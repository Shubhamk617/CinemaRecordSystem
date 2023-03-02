/**
 * 
 */
package com.cinemarecords.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinemarecords.dao.DirectorRepository;
import com.cinemarecords.model.Director;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName DirectorServicesImpl.java
 * @Description
 */
@Component
public class DirectorServicesImpl implements DirectorServices {

	@Autowired
	DirectorRepository directorRepository;

	@Override
	public Director saveDirector(Director director) {
		// TODO Auto-generated method stub
		return directorRepository.save(director);
	}

	@Override
	public List<Director> getDirectors() {
		// TODO Auto-generated method stub
		return directorRepository.findAll();
	}

	@Override
	public Optional<Director> getDirectorById(int directorId) {
		// TODO Auto-generated method stub
		return directorRepository.findById(directorId);
	}

	@Override
	public void updateDirector(Director director) {
		// TODO Auto-generated method stub
		directorRepository.save(director);

	}

	@Override
	public void deleteDirector(Director director) {
		// TODO Auto-generated method stub
		directorRepository.delete(director);

	}

	@Override
	public void deleteDirectorById(int directorId) {
		// TODO Auto-generated method stub
		directorRepository.deleteById(directorId);
	}

}
