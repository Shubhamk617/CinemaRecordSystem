/**
 * 
 */
package com.cinemarecords.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileNname Actor.java
 * @Description
 */
@Entity
@Table(name = "Actor")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "actorId")
public class Actor {

	@Id
	@Column(name = "actor_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorId;

	@Column(name = "actor_Nname")
	private String name;

	@Column(name = "actor_DOB")
	private Date dob;

	@Column(name = "actor_height")
	private int heightInCm;

	@Column(name = "years_Active")
	private String yearsActive;

	@ElementCollection
	@CollectionTable(name = "awards_list", joinColumns = @JoinColumn(name = "actor_Id"))
	@Column(name = "awards")
	private List<String> awards;

	@ManyToMany(mappedBy = "actors", cascade = CascadeType.ALL)
	// @JsonManagedReference(value = "movie-actors")
	@JsonIgnore
	private Set<Movie> movies;

	public Actor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Actor(String name, Date dob, int heightInCm, String yearsActive, List<String> awards, Set<Movie> movies) {
		super();
		this.name = name;
		this.dob = dob;
		this.heightInCm = heightInCm;
		this.yearsActive = yearsActive;
		this.awards = awards;
		this.movies = movies;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
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

	public int getHeightInCm() {
		return heightInCm;
	}

	public void setHeightInCm(int heightInCm) {
		this.heightInCm = heightInCm;
	}

	public String getYearsActive() {
		return yearsActive;
	}

	public void setYearsActive(String yearsActive) {
		this.yearsActive = yearsActive;
	}

	public List<String> getAwards() {
		return awards;
	}

	public void setAwards(List<String> awards) {
		this.awards = awards;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

//	private List<Movie> moviesAppearedIn;

}
