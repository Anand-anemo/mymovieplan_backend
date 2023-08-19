package com.mymovieplan.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieplan.project.model.movie.Genres;
import com.mymovieplan.project.repository.GenreRepository;
import com.mymovieplan.project.service.GenreServices;

@Service
public class GenreServiceImpl implements GenreServices {
	
	@Autowired
	private GenreRepository genreRepo;

	@Override
	public Genres addGernre(Genres genres) {
		
		return this.genreRepo.save(genres);
	}

	@Override
	public Genres updateGenres(Genres genres) {
		
		return this.genreRepo.save(genres);
	}

	@Override
	public List<Genres> getGenres() {
		
		return (List<Genres>) this.genreRepo.findAll();
	}

	@Override
	public Genres getGenresById(int gid) {
		
		return this.genreRepo.findById(gid).get();
	}

	@Override
	public void deleteGenres(int gid) {
		Genres genres = new Genres();
		genres.setGid(gid);
		this.genreRepo.delete(genres);
		
	}

}
