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

import com.mymovieplan.project.model.movie.Genres;
import com.mymovieplan.project.service.impl.GenreServiceImpl;



@RestController
@RequestMapping("/genre")
@CrossOrigin("*")
public class GenreController {
	@Autowired
	private GenreServiceImpl genreServiceImpl;
	//adding genres
	@PostMapping("/")
	public ResponseEntity<Genres>addGenres(@RequestBody Genres genres){
		Genres genres1=this.genreServiceImpl.addGernre(genres);
	    return ResponseEntity.ok(genres1);
	}
	//getting genres by id
	@GetMapping("/{gid}")
	public Genres getGenresById(@PathVariable("gid") int gid) {
		return this.genreServiceImpl.getGenresById(gid);
	}
	//updating genres
	@PutMapping("/")
	public Genres updateGenres(@RequestBody Genres genres) {
		return this.genreServiceImpl.updateGenres(genres);
		
	}
	//getting all genres
	@GetMapping("/")
	public ResponseEntity<?> getGenres(){
		return ResponseEntity.ok(this.genreServiceImpl.getGenres());
	}
	
	@DeleteMapping("/{gid}")
	public void deleteGenre(@PathVariable("gid") int gid) {
		 this.genreServiceImpl.deleteGenres(gid);
		
	}
		
	
	

}
