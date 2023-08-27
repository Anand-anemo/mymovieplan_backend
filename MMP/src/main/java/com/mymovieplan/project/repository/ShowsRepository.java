package com.mymovieplan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Shows;

@Repository
public interface ShowsRepository extends JpaRepository<Shows,Integer> {

}
