package com.mymovieplan.project.model.movie;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MovieShows {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(name="movie_showsid")
	 private int movieshowsid;
	 @Temporal(TemporalType.DATE)
	    
	    private Date start;

	    @Temporal(TemporalType.DATE)
	    
	    private Date end;

	    
	    private int movieid;
	    
	    public MovieShows() {}

	    @JsonIgnore
	    @ManyToOne(targetEntity = Shows.class)
	    @JoinColumn(name="showid",referencedColumnName="showid")
	    private Shows show;
	    
//	    @ToString.Exclude
//	    @EqualsAndHashCode.Exclude
//	    @JoinColumn(name = "movie_show_id", referencedColumnName = "movieshowsid")
//	    @OneToMany(targetEntity = Booking.class, cascade = CascadeType.ALL)
	    @OneToMany(mappedBy="movieShow", cascade = CascadeType.ALL)
	    private List<Booking> bookings;
	    
	    @ToString.Exclude
	    @EqualsAndHashCode.Exclude
	    @OneToOne(targetEntity = Price.class, cascade = CascadeType.ALL)
	    @JoinColumn(name = "price_id")
	    private Price price;

		public MovieShows(int movieshowsid, Date start, Date end, int movieid, Shows show, List<Booking> bookings,
				Price price) {
			super();
			this.movieshowsid = movieshowsid;
			this.start = start;
			this.end = end;
			this.movieid = movieid;
			this.show = show;
			this.bookings = bookings;
			this.price = price;
		}

		public int getMovieshowsid() {
			return movieshowsid;
		}

		public void setMovieShowsid(int movieShowsid) {
			this.movieshowsid = movieShowsid;
		}

		public Date getStart() {
			return start;
		}

		public void setStart(Date start) {
			this.start = start;
		}

		public Date getEnd() {
			return end;
		}

		public void setEnd(Date end) {
			this.end = end;
		}

		public int getMovieid() {
			return movieid;
		}

		public void setMovieid(int movieid) {
			this.movieid = movieid;
		}

		public Shows getShow() {
			return show;
		}

		public void setShow(Shows show) {
			this.show = show;
		}

		public List<Booking> getBookings() {
			return bookings;
		}

		public void setBookings(List<Booking> bookings) {
			this.bookings = bookings;
		}

		public Price getPrice() {
			return price;
		}

		public void setPrice(Price price) {
			this.price = price;
		}
	    
	    



	  
	 

}
