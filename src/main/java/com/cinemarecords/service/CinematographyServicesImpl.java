/**
 * 
 */
package com.cinemarecords.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cinemarecords.dao.CinematographyRepository;
import com.cinemarecords.model.Cinematography;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName CinematographyServicesImpl.java
 * @Description
 */
@Component
public class CinematographyServicesImpl implements CinematographyServices {

	@Autowired
	CinematographyRepository cinematographyRepository;

	@Override
	public Cinematography saveCinematography(Cinematography cinematography) {
		// TODO Auto-generated method stub
		return cinematographyRepository.save(cinematography);
	}

	@Override
	public List<Cinematography> getCinematographys() {
		// TODO Auto-generated method stub
		return cinematographyRepository.findAll();
	}

	@Override
	public Optional<Cinematography> getCinematographyById(int cinematographyId) {
		// TODO Auto-generated method stub
		return cinematographyRepository.findById(cinematographyId);
	}

	@Override
	public void updateCinematography(Cinematography cinematography) {
		// TODO Auto-generated method stub
		cinematographyRepository.save(cinematography);

	}

	@Override
	public void deleteCinematography(Cinematography cinematography) {
		// TODO Auto-generated method stub
		cinematographyRepository.delete(cinematography);

	}

	@Override
	public void deleteCinematographyById(int cinematographyId) {
		// TODO Auto-generated method stub
		cinematographyRepository.deleteById(cinematographyId);
	}

}
