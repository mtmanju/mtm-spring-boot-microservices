package com.mtm.examples.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.service.MovieService;

@RestController
@RequestMapping("/rest/api/movies")
public class MovieRestController {

	@Autowired
	MovieService movieService;

	@GetMapping
	public List<Movie> getAllMovies() {
		return movieService.getAllMovies();
	}

	@GetMapping("/{moviename}")
	public Movie getMovieByMovieName(@PathVariable("moviename") String movieName) {
		return movieService.getMovieByMovieName(movieName);
	}

	@PostMapping
	public Movie createMovie(@RequestBody MovieDto movieDto) {
		return movieService.createMovie(movieDto);
	}

}