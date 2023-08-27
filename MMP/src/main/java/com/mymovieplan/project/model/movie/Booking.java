package com.mymovieplan.project.model.movie;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Bookingid;
	 private double amount;

	    
	    private int totalSeats;

	    @Temporal(TemporalType.DATE)
	    private Date bookedOn;

	    
	    @Temporal(TemporalType.DATE)
	    private Date dateOfBooking;

	    @Column(name = "user_id")
	    private String userId;
	    
	    @ToString.Exclude
	    @EqualsAndHashCode.Exclude
	    @ElementCollection
	    @CollectionTable(name = "booked_seats", joinColumns = @JoinColumn(name = "booking_id"))
	    @Column(name = "seat_numbers")
	    private List<String> seatNumbers;
	    
	    @ToString.Exclude
	    @EqualsAndHashCode.Exclude
	    @OneToOne(targetEntity = Payment.class, cascade = CascadeType.ALL)
	    @JoinColumn(name = "payment_id")
	    private Payment payment;


	    
	    @ToString.Exclude
	    @EqualsAndHashCode.Exclude
	    @OneToOne(targetEntity = BookingDetails.class, cascade = CascadeType.ALL)
	    @JoinColumn(name = "booking_details_id")
	    private BookingDetails bookingDetails;
	    
		 
		@JsonIgnore
		@ManyToOne()
		@JoinColumn(name="movieshowid",referencedColumnName="movieshowsid")
	    private MovieShows movieShow;
		
		public Booking() {}

		public Booking(double amount, int totalSeats, Date bookedOn, Date dateOfBooking, String userId,
				List<String> seatNumbers, Payment payment, MovieShows movieShow) {
			super();
			this.amount = amount;
			this.totalSeats = totalSeats;
			this.bookedOn = bookedOn;
			this.dateOfBooking = dateOfBooking;
			this.userId = userId;
			this.seatNumbers = seatNumbers;
			this.payment = payment;
			this.movieShow = movieShow;
		}

		public int getBookingid() {
			return Bookingid;
		}

		public void setBookingid(int bookingid) {
			Bookingid = bookingid;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public int getTotalSeats() {
			return totalSeats;
		}

		public void setTotalSeats(int totalSeats) {
			this.totalSeats = totalSeats;
		}

		public Date getBookedOn() {
			return bookedOn;
		}

		public void setBookedOn(Date bookedOn) {
			this.bookedOn = bookedOn;
		}

		public Date getDateOfBooking() {
			return dateOfBooking;
		}

		public void setDateOfBooking(Date dateOfBooking) {
			this.dateOfBooking = dateOfBooking;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public List<String> getSeatNumbers() {
			return seatNumbers;
		}

		public void setSeatNumbers(List<String> seatNumbers) {
			this.seatNumbers = seatNumbers;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public BookingDetails getBookingDetails() {
			return bookingDetails;
		}

		public void setBookingDetails(BookingDetails bookingDetails) {
			this.bookingDetails = bookingDetails;
		}

		public MovieShows getMovieShow() {
			return movieShow;
		}

		public void setMovieShow(MovieShows movieShow) {
			this.movieShow = movieShow;
		}
	    
	    

}
