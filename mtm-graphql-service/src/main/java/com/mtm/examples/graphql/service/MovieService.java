package com.mtm.examples.graphql.service;

import java.util.List;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;

public interface MovieService {

	public List<Movie> getAllMovies();

	public Movie getMovieByMovieName(String movieName);

	public Movie createMovie(MovieDto movieDto);

}