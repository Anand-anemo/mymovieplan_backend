package com.mymovieplan.project.service;

import java.util.List;

import com.mymovieplan.project.model.movie.Theatre;

public interface TheatreService {
	
	public Theatre addTheatre(Theatre theatre);
	public Theatre updateTheatre(Theatre theatre);
	public List<Theatre> getTheatre();
	public Theatre getTheatreById(int tid);
	public void deleteTheatre(int tid);

}
