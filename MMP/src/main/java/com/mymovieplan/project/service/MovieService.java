package com.mymovieplan.project.service;

import java.util.List;

import com.mymovieplan.project.model.movie.Movies;

public interface MovieService {
	
	public Movies addMovie(Movies movies);
	public Movies updateMovies(Movies movies);
	public List<Movies> getMovies();
	public Movies getMovieById(int movieid);
	public void deleteMovie(int movieid);
	

}
