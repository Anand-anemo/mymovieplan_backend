package com.mymovieplan.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.project.exception.ShowNotFoundException;
import com.mymovieplan.project.model.movie.MovieShows;
import com.mymovieplan.project.model.movie.Shows;
import com.mymovieplan.project.repository.MovieShowsRepository;
import com.mymovieplan.project.repository.ShowsRepository;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/show")
@AllArgsConstructor
public class ShowController {
	
	@Autowired
	private ShowsRepository showRepo;
	@Autowired
	private MovieShowsRepository movieshowRepo;
	
	   @GetMapping("/{show_id}")
	    public Shows findShowById(@PathVariable final int show_id) {
	        return this.showRepo.findById(show_id)
	                .orElseThrow(() -> new ShowNotFoundException("Show with Id: " + show_id + " not found"));
	    }
	
	
	  @GetMapping("{show_id}/movie-show/all")
	  public List<MovieShows> findAllMovieShows(@PathVariable final int show_id) {
	  return this.findShowById(show_id)
	                .getMovieShows();
	    }


}
