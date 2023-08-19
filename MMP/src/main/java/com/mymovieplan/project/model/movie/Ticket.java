package com.mymovieplan.project.model.movie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  int ticketid;
	private String ticketType;
	private double ticketprice;
	private int ticketSeats;
	


	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

//	public Theatre getTheatre() {
//		return theatre;
//	}
//
//	public void setTheatre(Theatre theatre) {
//		this.theatre = theatre;
//	}

	public Ticket() {
		
	}

	public Ticket(int ticketid, String ticketType, double ticketprice, int ticketSeats) {
		super();
		this.ticketid = ticketid;
		this.ticketType = ticketType;
		this.ticketprice = ticketprice;
		this.ticketSeats = ticketSeats;
	}

	

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public double getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}

	public int getTicketSeats() {
		return ticketSeats;
	}

	public void setTicketSeats(int ticketSeats) {
		this.ticketSeats = ticketSeats;
	}

	
	
	

}
