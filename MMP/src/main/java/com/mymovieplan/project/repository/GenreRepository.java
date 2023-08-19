package com.mymovieplan.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Genres;
@Repository
public interface GenreRepository extends CrudRepository<Genres,Integer> {

}
