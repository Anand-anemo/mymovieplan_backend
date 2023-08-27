package com.mymovieplan.project.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookedSeats {
	
	public BookedSeats() {}
	
	
	public BookedSeats(int count, List<String> seats) {
		super();
		this.count = count;
		this.seats = seats;
	}


	private int count;
	private List<String> seats;
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public List<String> getSeats() {
		return seats;
	}


	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

}
