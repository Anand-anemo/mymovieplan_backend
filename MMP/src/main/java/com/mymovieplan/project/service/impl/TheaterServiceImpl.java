package com.mymovieplan.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.project.model.movie.Theatre;
import com.mymovieplan.project.repository.TheatreRepository;
import com.mymovieplan.project.service.TheatreService;

@Service
public class TheaterServiceImpl implements TheatreService {
	
	@Autowired
	private TheatreRepository theatreRepository;

	@Override
	public Theatre addTheatre(Theatre theatre) {
		
		return this.theatreRepository.save(theatre);
	}

	@Override
	public Theatre updateTheatre(Theatre theatre) {
		
		return this.theatreRepository.save(theatre);
	}

	@Override
	public List<Theatre> getTheatre() {
		
		return (List<Theatre>) this.theatreRepository.findAll();
	}

	@Override
	public Theatre getTheatreById(int tid) {
		
		return this.theatreRepository.findById(tid).get();
	}

	@Override
	public void deleteTheatre(int tid) {
		Theatre theatre=new Theatre();
		theatre.setTid(tid);
		this.theatreRepository.delete(theatre);
		
	}
	
	

}
