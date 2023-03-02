/**
 * 
 */
package com.cinemarecords.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemarecords.model.Movie;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieRepository.java
 * @Description
 */

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
