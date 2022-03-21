package io.javabrains.movieinfoservice.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Movie {
	@Id
    private String movieId;
	private String name;
	private String description;
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripition() {
		return description;
	}
	public void setDescripition(String descripition) {
		this.description = descripition;
	}
	public Movie(String movieId, String name, String descripition) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.description = descripition;
	}
	public Movie() {
		super();
	}
	
}
