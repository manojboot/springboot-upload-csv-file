package com.stackoverflow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackoverflow.model.Movie;
import com.stackoverflow.repository.MovieRepository;

@Service
public class MovieService {
	
		
		private MovieRepository movieRepository;
		public MovieService(MovieRepository movieRepository) {
			super();
			this.movieRepository = movieRepository;
		}
		
		public List<Movie> getMovieByGenre(){
			
			return movieRepository.findAll();
		}
		
		public Movie addMovie(Movie movie){
			
			return movieRepository.save(movie);
		}
}
