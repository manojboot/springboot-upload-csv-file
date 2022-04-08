package com.stackoverflow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackoverflow.model.Movie;
import com.stackoverflow.model.MovieId;

@Repository
public interface MovieRepository extends JpaRepository<Movie, MovieId>{

	public List<Movie> getMovieByGenre(String genre);
	
	@Modifying
	@Query("delete from Movie m where m.genre = :genre")
	public void deleteByGenre(@Param("genre") String genre);
}
