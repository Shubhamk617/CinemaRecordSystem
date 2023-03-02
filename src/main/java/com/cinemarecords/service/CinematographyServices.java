/**
 * 
 */
package com.cinemarecords.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cinemarecords.model.Cinematography;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName CinematographyServices.java
 * @Description
 */
@Component
public interface CinematographyServices {

	public Cinematography saveCinematography(Cinematography cinematography);

	public List<Cinematography> getCinematographys();

	public Optional<Cinematography> getCinematographyById(int cinematographyId);

	public void updateCinematography(Cinematography cinematography);

	public void deleteCinematography(Cinematography cinematography);

	public void deleteCinematographyById(int cinematographyId);

}
