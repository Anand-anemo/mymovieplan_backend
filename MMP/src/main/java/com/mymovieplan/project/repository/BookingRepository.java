package com.mymovieplan.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mymovieplan.project.model.movie.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
	
	List<Booking> findAllByUserIdOrderByBookedOnAsc(final String userId);

}
