package com.mymovieplan.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Theatre;

@Repository
public interface TheatreRepository extends CrudRepository<Theatre,Integer>{

	

}
