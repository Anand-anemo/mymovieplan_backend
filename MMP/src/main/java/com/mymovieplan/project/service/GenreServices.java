package com.mymovieplan.project.service;

import java.util.List;

import com.mymovieplan.project.model.movie.Genres;



public interface GenreServices {
	
	//add genre
	public Genres addGernre(Genres genres);
	//update genre
	public Genres updateGenres(Genres genres);
	//get genre
	public List<Genres> getGenres();
	//get genres by id
	public Genres getGenresById(int gid);
	//delete genre
	public void deleteGenres(int gid);

}
