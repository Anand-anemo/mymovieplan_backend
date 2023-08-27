package com.mymovieplan.project.model.movie;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Shows {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int showid;
	private String name;

   
    private String startTime;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<MovieShows> getMovieShows() {
		return movieShows;
	}

	public void setMovieShows(List<MovieShows> movieShows) {
		this.movieShows = movieShows;
	}
	
	 
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="theatreid",referencedColumnName="tid")
	private Theatre theatre;
	
	
	
	
	


    
    public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}


//	@ToString.Exclude
//    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="show", cascade = CascadeType.ALL)
//    @JoinColumn(name = "show_id", referencedColumnName = "showid")
    private List<MovieShows> movieShows;
    
    

	public Shows() {
		
		// TODO Auto-generated constructor stub
	}

	public Shows(int showid, String name, String startTime, Theatre theatre, List<MovieShows> movieShows) {
		super();
		this.showid = showid;
		this.name = name;
		this.startTime = startTime;
		this.theatre = theatre;
		this.movieShows = movieShows;
	}

	public int getShowid() {
		return showid;
	}

	public void setShowid(int showid) {
		this.showid = showid;
	}
	
	

	
    
    

	
	


}
