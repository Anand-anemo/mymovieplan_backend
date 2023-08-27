package com.mymovieplan.project.model.movie;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Theatre {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tid;
	
	private String theatreName;
	private String Address;
	private String location;
	private String city;
	private String phoneno;
	private int seatCapacity;
	
	
	 
     //@JoinColumn(name = "theatre_id", referencedColumnName = "tid")
	 @OneToMany(mappedBy="theatre", cascade = CascadeType.ALL)
	 private List<Shows> shows;

	
	public List<Shows> getShows() {
		return shows;
	}
	public void setShows(List<Shows> shows) {
		this.shows = shows;
	}
	
    public Theatre() {
		
	}
    


public Theatre(int tid, String theatreName, String address, String location, String city, String phoneno,
			int seatCapacity, List<Shows> shows) {
		super();
		this.tid = tid;
		this.theatreName = theatreName;
		Address = address;
		this.location = location;
		this.city = city;
		this.phoneno = phoneno;
		this.seatCapacity = seatCapacity;
		this.shows = shows;
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

    public int getSeatCapacity() {
	return seatCapacity;
}

    public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}
}



	
//	public List<Ticket> getTicket() {
//		return ticket;
//	}
//	public void setTicket(List<Ticket> ticket) {
//		this.ticket = ticket;
//	}
//	public Set<Movies> getMovies() {
//		return movies;
//	}
//	public void setMovies(Set<Movies> movies) {
//		this.movies = movies;
//	}
////
//	@ManyToMany(mappedBy="MovieTheatre" ,fetch=FetchType.EAGER)
//	@JsonIgnore
//	private Set<Movies>movies = new HashSet<>();

	








	
	

	

	












//
//	public Theatre(int tid, String theatreName, String address, String location, String city, String phoneno,
//			List<Ticket> ticket, Set<Movies> movies) {
//		super();
//		this.tid = tid;
//		this.theatreName = theatreName;
//		Address = address;
//		this.location = location;
//		this.city = city;
//		this.phoneno = phoneno;
//		this.ticket = ticket;
//		this.movies = movies;
//	}





	








	
	


