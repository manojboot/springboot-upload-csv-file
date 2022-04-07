package com.stackoverflow.model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@EmbeddedId
	private MovieId id;
	private int duration;
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
	private int rating;
	private String genre;

}
