package com.mymovieplan.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.project.model.movie.Movies;
import com.mymovieplan.project.service.impl.MovieServiceImpl;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MoviesController {
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	//adding movies
	@PostMapping("/")
	public ResponseEntity<Movies> addMovie( @RequestBody Movies movie ) {
	
		return ResponseEntity.ok(this.movieServiceImpl.addMovie(movie));
		
		
	}

	

	
	//getting all movies
	@GetMapping("/")
	public ResponseEntity<?> getMovies(){
		return ResponseEntity.ok(this.movieServiceImpl.getMovies());
	}
	
	//getting moviesById
	@GetMapping("/{movieid}")
	public Movies getMovieById(@PathVariable("movieid")int movieid) {
		return this.movieServiceImpl.getMovieById(movieid);
	}
	
	//updating movie
	@PutMapping("/")
	public Movies updateMovie(@RequestBody Movies movies) {
		return this.movieServiceImpl.updateMovies(movies);
	}
	
	//delete movies
	@DeleteMapping("/{movieid}")
	public void deleteMovies(@PathVariable("movieid") int movieid){
		
		this.movieServiceImpl.deleteMovie(movieid);
	}
	
	@PostMapping("/movietheatres")
	public Movies asignTheatresToMovie(@RequestParam(defaultValue="0")int movieid,
			@RequestParam(defaultValue="0")int tid) {
		return this.movieServiceImpl.assignTheatreToMovie(movieid, tid);
	}
	

}
