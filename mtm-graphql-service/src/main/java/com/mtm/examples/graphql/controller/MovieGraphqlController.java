package com.mtm.examples.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.service.MovieService;

@Controller
public class MovieGraphqlController {

	@Autowired
	MovieService movieService;

	@QueryMapping("getAllMovies")
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@QueryMapping("getMovieByMovieName")
	public Movie getMovieByMovieName(@Argument String moviename) {
		return movieService.getMovieByMovieName(moviename);
	}

	@MutationMapping("createMovie")
	public Movie createMovie(@Argument MovieDto movieDto) {
		return movieService.createMovie(movieDto);
	}

}