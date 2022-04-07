package com.stackoverflow.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "employee")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Column(length = 45)
	private String firstName;
	@Column(length = 45)
	private String lastName;
	@Id
	@Column(length = 45)
	private String email;

	@Column(length = 20)
	private String gender;
	

}
