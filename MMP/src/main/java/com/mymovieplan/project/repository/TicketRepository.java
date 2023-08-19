package com.mymovieplan.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Integer> {

}
