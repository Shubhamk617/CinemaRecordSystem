/**
 * 
 */
package com.cinemarecords.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinemarecords.model.Actor;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName MovieRepository.java
 * @Description
 */

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
