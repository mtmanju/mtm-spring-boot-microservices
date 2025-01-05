package com.mtm.examples.graphql.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.DecimalMax;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {

	private static final long serialVersionUID = 7826348491522043735L;

	@NotBlank(message = "Movie name is required")
	private String movieName;
	
	@NotBlank(message = "Lead actor is required")
	private String leadActor;
	
	@NotBlank(message = "Lead actress is required")
	private String leadActress;
	
	@NotBlank(message = "Genre is required")
	private String genre;
	
	@NotBlank(message = "Producer is required")
	private String producer;
	
	@NotBlank(message = "Director is required")
	private String director;
	
	@NotNull(message = "IMDB rating is required")
	@DecimalMin(value = "0.0", message = "Rating should be at least 0")
	@DecimalMax(value = "10.0", message = "Rating should not exceed 10")
	private Double imdbRating;

}