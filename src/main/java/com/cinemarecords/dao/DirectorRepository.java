/**
 * 
 */
package com.cinemarecords.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemarecords.model.Director;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieRepository.java
 * @Description
 */

public interface DirectorRepository extends JpaRepository<Director, Integer> {

}
