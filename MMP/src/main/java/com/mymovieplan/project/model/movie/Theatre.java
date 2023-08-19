package com.mymovieplan.project.model.movie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Theatre {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	
	private String theatreName;
	private String Address;
	private String location;
	private String city;
	private String phoneno;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="theaterid" , referencedColumnName="tid")
	private List<Ticket> ticket;
	
	
	
	




	public List<Ticket> getTicket() {
		return ticket;
	}





	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}





	public Set<Movies> getMovies() {
		return movies;
	}





	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}

	@ManyToMany(mappedBy="MovieTheatre" ,fetch=FetchType.EAGER)
	@JsonIgnore
	private Set<Movies>movies = new HashSet<>();

	

	

	public Theatre() {
		
	}
	

	

	





	public Theatre(int tid, String theatreName, String address, String location, String city, String phoneno,
			List<Ticket> ticket, Set<Movies> movies) {
		super();
		this.tid = tid;
		this.theatreName = theatreName;
		Address = address;
		this.location = location;
		this.city = city;
		this.phoneno = phoneno;
		this.ticket = ticket;
		this.movies = movies;
	}





	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
	

}
