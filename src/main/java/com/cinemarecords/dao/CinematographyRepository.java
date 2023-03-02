/**
 * 
 */
package com.cinemarecords.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemarecords.model.Cinematography;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieRepository.java
 * @Description
 */

public interface CinematographyRepository extends JpaRepository<Cinematography, Integer> {

}
