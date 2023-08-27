package com.mymovieplan.project.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.project.exception.MovieShowNotFoundException;
import com.mymovieplan.project.exception.ShowNotFoundException;
import com.mymovieplan.project.model.movie.Booking;
import com.mymovieplan.project.model.movie.BookingDetails;
import com.mymovieplan.project.model.movie.MovieShows;
import com.mymovieplan.project.model.movie.Shows;
import com.mymovieplan.project.model.movie.Theatre;
import com.mymovieplan.project.repository.BookingRepository;
import com.mymovieplan.project.repository.MovieShowsRepository;
import com.mymovieplan.project.repository.MoviesRepository;
import com.mymovieplan.project.repository.ShowsRepository;
import com.mymovieplan.project.repository.TheatreRepository;
import com.mymovieplan.project.service.TheatreService;
import com.mymovieplan.project.service.UserService;

@RestController
@RequestMapping("/theatre")
@CrossOrigin("*")
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
	@Autowired
	private TheatreRepository theatreRepo;
	@Autowired
	private ShowsRepository showsRepo;
	@Autowired
	private MoviesRepository movieRepo;
	@Autowired
	private MovieShowsRepository movieshowRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private BookingRepository bookingRepo;
	
	//adding theatre
	@PostMapping("/")
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre){
		return ResponseEntity.ok(this.theatreService.addTheatre(theatre));
	}
	
	//getting theatre details
	@GetMapping("/")
	public List<Theatre> getTheatre(){
		return this.theatreService.getTheatre();
	}
	
	//getting theatreById
	@GetMapping("/{tid}")
	public Theatre getTheatreById(@PathVariable("tid") int tid) {
		return this.theatreService.getTheatreById(tid);
		
	}
	
	//update threatredetails
	@PutMapping("/")
	public Theatre updateTheatre(@RequestBody Theatre theatre) {
		return this.theatreService.updateTheatre(theatre);
	}
	
	//delete Theatre
	@DeleteMapping("/{tid}")
	public void deleteTheatre(@PathVariable("tid") int tid) {
		this.theatreService.deleteTheatre(tid);
	}
//	@PostMapping("/addtheatreticket")
//	public Theatre addTheatreAndTicket(@RequestBody TheatreRequest theatreRequest) {
//		
//		Theatre theatre = new Theatre();
//		Ticket ticket = new Ticket();
//	    theatre.setTicket(theatreRequest.getTheatre().getTicket());
//	    ticket = ticketRepo.save()
//		
//	}
	
	//saving shows
	  @PostMapping("/{tid}/shows/add")
	  public Shows saveShow(@PathVariable  int tid,
	                               @RequestBody  Shows shows) {
	         Theatre theatre = this.getTheatreById(tid);
	        shows.setTheatre(theatre);
	        return this.showsRepo.save(shows);
	    }
	  @GetMapping("/{tid}/show/{showid}")
	    public Shows findShowById(@PathVariable final int tid,
	                                   @PathVariable final int showid) {
	        return this.getTheatreById(tid).getShows()
	                .stream()
	                .filter(show -> show.getShowid() == showid)
	                .findFirst()
	                .orElseThrow(() ->
	                        new ShowNotFoundException("Show with Id: " + showid + " not found"));
	               // .findFirst()
	               // ;
	    }
	  @GetMapping("/{tid}/show/all")
	    public List<Shows> findAllShows(@PathVariable final int tid) {
	        return this.getTheatreById(tid).getShows();
	    }
	  
	  @PostMapping("{tid}/show/{showid}/movieShow/add")
	  public MovieShows saveMovieShow(@PathVariable final int tid,
	                                          @PathVariable final int showid,
	                                          @RequestBody final MovieShows movieShow) {
	        final Shows show = this.findShowById(tid, showid);
	        final int movieId = movieShow.getMovieid();
	        movieShow.setShow(show);
	       // movieShow.setMovieid(this.movie);
	       // Movies movie=new Movies();
	        
	        movieShow.setMovieid(this.movieRepo.findById(movieId).get().getMovieid());
	        return this.movieshowRepo.save(movieShow);
	    }
	  
	  @GetMapping("/movie/{movieId}")
	    public List<Theatre> findTheatreByMovieid(@PathVariable final int movieId) {
	        return this.getTheatre().stream()
	                .filter(halls -> halls.getShows()
	                        .stream()
	                        .anyMatch(show -> show.getMovieShows()
	                                .stream()
	                                .anyMatch(m_show -> m_show.getMovieid() == movieId)))
	                .collect(Collectors.toList());
	    }
	  
	  @GetMapping("{auditorium_id}/movie/{movieId}")
	    public List<Shows> findShowsByMovieId(@PathVariable final int auditorium_id, @PathVariable final int movieId) {
	        return this.findAllShows(auditorium_id).stream()
	                .filter(show -> show.getMovieShows()
	                        .stream()
	                        .anyMatch(m_show -> m_show.getMovieid() == movieId))
	                .collect(Collectors.toList());
	    }
	  
	  @GetMapping("/{auditorium_id}/show/{show_id}/movie-show/{movie_show_id}")
	    public MovieShows findMovieShowById(@PathVariable final int auditorium_id,
	                                              @PathVariable final int show_id,
	                                              @PathVariable final int movie_show_id) {
	        return this.findShowById(auditorium_id, show_id)
	                .getMovieShows()
	                .stream()
	                .filter(movie_show -> movie_show.getMovieshowsid() == movie_show_id)
	                .findFirst()
	                .orElseThrow(
	                        () -> new MovieShowNotFoundException("Movie Show with id: "
	                                + movie_show_id + " not found"));
	    }
	  
	  @PostMapping("/{auditorium_id}/show/{show_id}/movie-show/{movie_show_id}/booking/add")
//    @PreAuthorize("hasAuthority('WRITE')")
      public Booking saveBooking(@PathVariable final int auditorium_id,
                                     @PathVariable final int show_id,
                                     @PathVariable final int movie_show_id,
                                     @RequestBody final Booking booking) {
        final MovieShows moveShow = this.findMovieShowById(auditorium_id, show_id, movie_show_id);
       // booking.setUserId(this.userService.getLoggedInUser().getId());
//        booking.setUserId(this.service.findByMobile("8099531318").get().getId());
        booking.setMovieShow(moveShow);
        booking.setBookingDetails(new BookingDetails(auditorium_id, show_id, movie_show_id, moveShow.getMovieid()));
        return this.bookingRepo.save(booking);
  

	  }
	
	

}
