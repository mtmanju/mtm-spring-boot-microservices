package com.mtm.examples.graphql.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Movie implements Serializable {

	private static final long serialVersionUID = 3580483023304980589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "lead_actor")
	private String leadActor;

	@Column(name = "lead_actress")
	private String leadActress;

	@Column(name = "genre")
	private String genre;

	@Column(name = "producer")
	private String producer;

	@Column(name = "director")
	private String director;

	@Column(name = "imdb_rating")
	private Double imdbRating;

}