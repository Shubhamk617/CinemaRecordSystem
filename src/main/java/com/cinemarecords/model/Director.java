/**
 * 
 */
package com.cinemarecords.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName Director.java
 * @Description
 */
@Entity
@Table(name = "Director")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "directorId")
public class Director {

	@Id
	@Column(name = "director_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int directorId;

	@Column(name = "director_Name")
	private String name;

	@Column(name = "director_DOB")
	private Date dob;

	@Column(name = "director_Alma_Matter")
	private String almaMatter;

	@Column(name = "years_Active")
	private String yearsActive;

	@Column(name = "director_Website")
	private String website;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "director", fetch = FetchType.LAZY)
	@JsonBackReference(value = "movie-director")
	private Movie movie;

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String name, Date dob, String almaMatter, String yearsActive, String website, Movie movie) {
		super();
		this.name = name;
		this.dob = dob;
		this.almaMatter = almaMatter;
		this.yearsActive = yearsActive;
		this.website = website;
		this.movie = movie;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getAlmaMatter() {
		return almaMatter;
	}

	public void setAlmaMatter(String almaMatter) {
		this.almaMatter = almaMatter;
	}

	public String getYearsActive() {
		return yearsActive;
	}

	public void setYearsActive(String yearsActive) {
		this.yearsActive = yearsActive;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/*
	 * @OneToOne(mappedBy = "director", cascade = CascadeType.ALL) private Movie
	 * movie;
	 */

	// private List<Movie> moviesKnownFor;

}
