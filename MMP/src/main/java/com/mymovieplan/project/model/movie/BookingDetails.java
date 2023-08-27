package com.mymovieplan.project.model.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BookingDetails {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int BookingDetailsid;
	  
	    private int tid;

	    
	    private int showId;

	    
	    private int movieShowId;

	   
	    private int movieid;
	    
	    public BookingDetails() {}


		public BookingDetails( int tid, int showId, int movieShowId, int movieid) {
			super();
			//BookingDetailsid = bookingDetailsid;
			this.tid = tid;
			this.showId = showId;
			this.movieShowId = movieShowId;
			this.movieid = movieid;
		}
	    


}
