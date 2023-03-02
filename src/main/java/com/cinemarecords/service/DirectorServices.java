/**
 * 
 */
package com.cinemarecords.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cinemarecords.model.Director;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName DirectorServices.java
 * @Description
 */
@Component
public interface DirectorServices {

	public Director saveDirector(Director director);

	public List<Director> getDirectors();

	public Optional<Director> getDirectorById(int directorId);

	public void updateDirector(Director director);

	public void deleteDirector(Director director);

	public void deleteDirectorById(int directorId);

}
