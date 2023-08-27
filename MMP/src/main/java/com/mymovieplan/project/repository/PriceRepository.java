package com.mymovieplan.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price,Integer>{

}
