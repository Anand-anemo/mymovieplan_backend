package com.mymovieplan.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.project.model.movie.Movies;
import com.mymovieplan.project.repository.MoviesRepository;
import com.mymovieplan.project.repository.TheatreRepository;
import com.mymovieplan.project.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService{
	@Autowired
	private MoviesRepository moviesRepo;
	@Autowired
	private TheatreRepository theatreRepo;
	
	@Override
	public Movies addMovie(Movies movies ) {
//		Set<Theatre> addTheatre=null;
//		//numbers =  Arrays.asList(selectedTheatreid);
//		//selectedTheatreid = new ArrayList<>(); 
//		for(int i=0;i<=params.size(); i++) {
//			Theatre theatre = theatreRepo.findById(params.get(i)).get();
//			addTheatre=movies.getMovieTheatre();
//			addTheatre.add(theatre);
//			movies.setMovieTheatre(addTheatre);
//		}
		return this.moviesRepo.save(movies);
	}
//
//	@Override
//	public Movies addMovie(Movies movies , List<Integer> selectedTheatreid) {
//		Set<Theatre> addTheatre=null;
//		Theatre theatre = theatreRepo.findById(tid).get();
//		addTheatre=movies.getMovieTheatre();
//		addTheatre.add(theatre);
//		movies.setMovieTheatre(addTheatre);
//		
////		Movies movie = this.moviesRepo.findByMovieName(movies.getMovieName());
////		if(movie != null) {
////			System.out.println("movie already in database");
////		}else{
////			return this.moviesRepo.save(movies);
////		}
////		
//		return this.moviesRepo.save(movies);
//	}

	@Override
	public Movies updateMovies(Movies movies) {
		
		return this.moviesRepo.save(movies);
	}

	@Override
	public List<Movies> getMovies() {
		
		return (List<Movies>) this.moviesRepo.findAll();
	}

	@Override
	public Movies getMovieById(int movieid) {
		
		return this.moviesRepo.findById(movieid).get();
	}

	@Override
	public void deleteMovie(int movieid) {
		Movies movies = new Movies();
		movies.setMovieid(movieid);
		this.moviesRepo.delete(movies);
		
	}

	

	

}
