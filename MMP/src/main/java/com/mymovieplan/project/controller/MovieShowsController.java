package com.mymovieplan.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.project.exception.MovieShowNotFoundException;
import com.mymovieplan.project.model.BookedSeats;
import com.mymovieplan.project.model.movie.Booking;
import com.mymovieplan.project.model.movie.MovieShows;
import com.mymovieplan.project.repository.MovieShowsRepository;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/movieshow")
@AllArgsConstructor
public class MovieShowsController {
	
	@Autowired
	private MovieShowsRepository movieshowRepo;
	
	@GetMapping("/{movie_show_id}")
	 public MovieShows findMovieShowById(@PathVariable final int movie_show_id) {
	        return this.movieshowRepo.findById(movie_show_id)
	                .orElseThrow(
	                        () -> new MovieShowNotFoundException("Movie Show with id: " + movie_show_id + " not found")
	                );
	    }
	
	 @GetMapping("/up-coming")
	 public List<MovieShows> upComing() {
	        
	            return movieshowRepo.findFewUpComing();
	        //return movieshowRepo.findAllUpComing();
	        }

	    @GetMapping("/now-playing")
	    public List<MovieShows> nowPlaying() {
       
            return movieshowRepo.findFewNowPlaying();
        //return movieshowRepo.findAllNowPlaying();
    }

	    @GetMapping("/now-playing-up-coming")
	    public List<MovieShows> nowPlayingAndUpComing() {
	        return movieshowRepo.findAllNowPlayingAndUpComing();
	    }
	    
	    @GetMapping("/{movie_show_id}/booked-seats/{on}")
	    public BookedSeats bookedSeats(@PathVariable final int movie_show_id, @PathVariable final String on) {
	        final List<Booking> bookings = this.findMovieShowById(movie_show_id).getBookings()
	                .stream().filter(m_show -> m_show.getDateOfBooking().toString().equals(on))
	                .collect(Collectors.toList());

	        int count = 0;
	        List<String> seats = new ArrayList<>();
	        for (Booking booking : bookings) {
	            count += booking.getTotalSeats();
	            seats.addAll(booking.getSeatNumbers());
	        }
	        return new BookedSeats(count, seats);
	    }

//	    @GetMapping("/not-playing")
//	     public List<MovieShows> notPlaying() {
//	        return movieshowRepo.findAllNotPlaying();
//	    }
	    
//	    @GetMapping("up-coming")
//	    
//	    public List<MovieShows> upComing() {
//	        if (records.isPresent())
//	            return repository.findFewUpComing(Integer.parseInt(records.get()));
//	        return repository.findAllUpComing();
//	    }
//
//	    @GetMapping("now-playing")
//	    public List<MovieShowsEntity> nowPlaying(@RequestParam(value = "records", required = false) Optional<String> records) {
//	        if (records.isPresent())
//	            return repository.findFewNowPlaying(Integer.parseInt(records.get()));
//	        return repository.findAllNowPlaying();
//	    }
//

}
