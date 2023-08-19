package com.mymovieplan.project.controller;

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

import com.mymovieplan.project.model.movie.Theatre;
import com.mymovieplan.project.service.TheatreService;

@RestController
@RequestMapping("/theatre")
@CrossOrigin("*")
public class TheatreController {
	
	@Autowired
	private TheatreService theatreService;
//	@Autowired
//	private TheatreRepository theatreRepo;
//	@Autowired
//	private TicketRepository ticketRepo;
	
	//adding theatre
	@PostMapping("/")
	public ResponseEntity<Theatre> addTheatre(@RequestBody Theatre theatre){
		return ResponseEntity.ok(this.theatreService.addTheatre(theatre));
	}
	
	//getting theatre details
	@GetMapping("/")
	public ResponseEntity<?> getTheatre(){
		return ResponseEntity.ok(this.theatreService.getTheatre());
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
	
	
	
	

}
