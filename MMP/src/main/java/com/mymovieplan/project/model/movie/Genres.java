package com.mymovieplan.project.model.movie;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Genres {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gid; 
	private String genreName;
	@OneToMany(mappedBy="genres",fetch=FetchType.EAGER, cascade=CascadeType.ALL )
	//@JoinColumn(name="genres gid",referencedColumnName="movieid")
	@JsonIgnore
	private Set<Movies>movies=new LinkedHashSet<>();
	
	public Set<Movies> getMovies() {
		return movies;
	}
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	public Genres() {}
	public Genres(int gid, String genreName) {
		super();
		this.gid = gid;
		this.genreName = genreName;
	}
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGenreName() {
		return genreName;
	}
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
	
	
	

}
