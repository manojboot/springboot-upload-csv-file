package com.stackoverflow.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackoverflow.model.Movie;
import com.stackoverflow.service.MovieService;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

	private MovieService movieService;
	public MovieController(MovieService movieService) {
		super();
		this.movieService = movieService;
	}

	@GetMapping("/allmovies")
	public ResponseEntity<List<Movie>> getMovieByGenre(){
		List<Movie> movies = movieService.getMovieByGenre();
		return ResponseEntity.ok(movies);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
		Movie movies = movieService.addMovie(movie);
		return ResponseEntity.ok(movies);
	}
}
