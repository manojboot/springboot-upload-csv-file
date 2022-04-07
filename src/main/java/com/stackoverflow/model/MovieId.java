package com.stackoverflow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieId implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(length = 100)
	private String name;
	@Column(length = 50)
	private String directedBy;
}
