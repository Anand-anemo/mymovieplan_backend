package com.mymovieplan.project.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.project.model.movie.Movies;
import com.mymovieplan.project.repository.MovieShowsRepository;
import com.mymovieplan.project.service.impl.MovieServiceImpl;

@RestController
@RequestMapping("/movies")
@CrossOrigin("*")
public class MoviesController {
	@Autowired
	private MovieServiceImpl movieServiceImpl;
	
	private MovieShowsRepository movieshowsRepo;
	//adding movies
	@PostMapping("/")
	public ResponseEntity<Movies> addMovie( @RequestBody Movies movie ) {
	
		return ResponseEntity.ok(this.movieServiceImpl.addMovie(movie));
		
		
	}

	

	
	//getting all movies
	@GetMapping("/")
	public List<Movies> getMovies(){
		return this.movieServiceImpl.getMovies();
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
	
	//findfewnowplaying
//	@GetMapping("/now-playing")
//    public List<Movies> nowPlaying(@RequestParam(value = "records", required = false) Optional<String> records) {
//        List<Movies> movies;
//        List<Movies> allMovies;
//        if (records.isPresent()) {
//            movies = new ArrayList<>();
//            allMovies =  this.getMovies();
//            movieshowsRepo.findFewNowPlaying(Integer.parseInt(records.get()))
//                    .forEach(m_show -> movies.add(allMovies.stream()
//                            .filter(movie -> movie.getMovieid() == m_show.getMovieid())
//                            .findFirst().orElse(null)));
//        } else {
//            movies = new ArrayList<>();
//            allMovies = this.getMovies();
//            movieshowsRepo.findAllNowPlaying()
//                    .forEach(m_show -> movies.add(allMovies.stream()
//                            .filter(movie -> movie.getMovieid() == m_show.getMovieid())
//                            .findFirst().orElse(null)));
//        }
//        movies.removeAll(Collections.singletonList(null));
//        return movies;
//    }
//	
//	//findfewupcoming
//	 @GetMapping("/up-coming")
//	    public List<Movies> upComing(@RequestParam(value = "records", required = false) Optional<String> records) {
//	        List<Movies> movies;
//	        List<Movies> allMovies;
//	        if (records.isPresent()) {
//	            movies = new ArrayList<>();
//	            allMovies = this.getMovies();
//	            movieshowsRepo.findFewUpComing(Integer.parseInt(records.get()))
//	                    .forEach(m_show -> movies.add(allMovies.stream()
//	                            .filter(movie -> (movie.getMovieid() == m_show.getMovieid() && movie.getRelease().getTime() > new Date().getTime()))
//	                            .findFirst().orElse(null)));
//	        } else {
//	            movies = new ArrayList<>();
//	            allMovies = this.getMovies();
//	            movieshowsRepo.findAllUpComing()
//	                    .forEach(m_show -> movies.add(allMovies.stream()
//	                            .filter(movie -> movie.getMovieid() == m_show.getMovieid() && movie.getRelease().getTime() > new Date().getTime())
//	                            .findFirst().orElse(null)));
//	        }
////	        return (movies.size() > 0 && !movies.contains(null)) ? movies : new ArrayList<>();
//	        //System.out.println(movies);
//	        movies.removeAll(Collections.singletonList(null));
//	        //System.out.println(movies);
//	        return movies;
//	    }
	 
	   @GetMapping("/now-playing-up-coming")
	    public List<Movies> nowPlayingAndUpComing() {
	        final List<Movies> movies = new ArrayList<>();
	        final List<Movies> allMovies = this.getMovies();
	        movieshowsRepo.findAllNowPlayingAndUpComing()
	                .forEach(m_show -> movies.add(allMovies.stream()
	                        .filter(movie -> movie.getMovieid() == m_show.getMovieid())
	                        .findFirst().orElse(null)));
	       movies.removeAll(Collections.singletonList(null));
	        return movies;
	    }

	
	
	

}
