package com.mymovieplan.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Movies;

@Repository
public interface MoviesRepository extends CrudRepository<Movies,Integer>{
	
	

}
