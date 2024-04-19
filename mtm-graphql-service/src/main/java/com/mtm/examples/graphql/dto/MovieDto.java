package com.mtm.examples.graphql.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {

	private static final long serialVersionUID = 7826348491522043735L;

	private String movieName;
	private String leadActor;
	private String leadActress;
	private String genre;
	private String producer;
	private String director;
	private Double imdbRating;

}