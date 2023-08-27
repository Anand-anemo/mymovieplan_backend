package com.mymovieplan.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieplan.project.model.movie.Booking;
import com.mymovieplan.project.repository.BookingRepository;
import com.mymovieplan.project.service.UserService;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BookingRepository bookingRepo;
	
	  @GetMapping("/{username}/all")
	  public List<Booking> findAllByUserId(@PathVariable String username) {
	        if (!(username.contains("-") && username.length() > 10))
	            username = "1";
	        return bookingRepo.findAllByUserIdOrderByBookedOnAsc(username);
	    }


}
