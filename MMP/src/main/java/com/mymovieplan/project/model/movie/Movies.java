package com.mymovieplan.project.model.movie;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int movieid;
	private String movieName;
	private String Language;
	private String imageurl;
	@Column(length= 2000)
	private String Summary;
	private boolean active=false;
	//@JsonFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date release;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="genreid",nullable=true)
	private Genres genres;
	public Genres getGenres() {
		return genres;
	}
	public void setGenres(Genres genres) {
		this.genres = genres;
	}


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "movie_theatre",
            joinColumns = {
                    @JoinColumn(name = "movie_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "theatre_id")
            }
    )
	
    private Set<Theatre>MovieTheatre=new HashSet<>();
	
	public Set<Theatre> getMovieTheatre() {
		return MovieTheatre;
	}
	public void setMovieTheatre(Set<Theatre> movieTheatre) {
		MovieTheatre = movieTheatre;
	}
	//default constructor
	public Movies() {
		
	}
	
	
	
	public Movies(int movieid, String movieName, String language, String imageurl, String summary, boolean active,
			Date release, Genres genres, Set<Theatre> movieTheatre) {
		super();
		this.movieid = movieid;
		this.movieName = movieName;
		Language = language;
		this.imageurl = imageurl;
		Summary = summary;
		this.active = active;
		this.release = release;
		this.genres = genres;
		MovieTheatre = movieTheatre;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLanguage() {
		return Language;
	}
	public void setLanguage(String language) {
		Language = language;
	}
	
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getSummary() {
		return Summary;
	}
	public void setSummary(String summary) {
		Summary = summary;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Date getRelease() {
		return release;
	}
	public void setRelease(Date release) {
		this.release = release;
	}
	

}
