/**
 * 
 */
package com.cinemarecords.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author shukumar5
 * @Date Feb 11, 2023
 * @fileName Cinematography.java
 * @Description
 */

@Entity
@Table(name = "Cinematography")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cinematographyId")
public class Cinematography {

	@Id
	@Column(name = "cinematography_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cinematographyId;

	@Column(name = "production_Name")
	private String productionName;

	@Column(name = "industry")
	private String industry;

	@Column(name = "founder")
	private String founder;

	@Column(name = "headQuarter")
	private String headQuarter;

	@Column(name = "website")
	private String website;

	@OneToMany(mappedBy = "cinematography", cascade = CascadeType.ALL)
	// @JsonManagedReference(value = "movie-cinematographies")
	@JsonIgnore
	private Set<Movie> movie;

	public Cinematography() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cinematography(String productionName, String industry, String founder, String headQuarter, String website,
			Set<Movie> movie) {
		super();
		this.productionName = productionName;
		this.industry = industry;
		this.founder = founder;
		this.headQuarter = headQuarter;
		this.website = website;
		this.movie = movie;
	}

	public int getCinematographyId() {
		return cinematographyId;
	}

	public void setCinematographyId(int cinematographyId) {
		this.cinematographyId = cinematographyId;
	}

	public String getProductionName() {
		return productionName;
	}

	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public String getHeadQuarter() {
		return headQuarter;
	}

	public void setHeadQuarter(String headQuarter) {
		this.headQuarter = headQuarter;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Set<Movie> getMovie() {
		return movie;
	}

	public void setMovie(Set<Movie> movie) {
		this.movie = movie;
	}

}
