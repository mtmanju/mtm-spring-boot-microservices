package com.mtm.examples.graphql.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.service.MovieService;

@RestController
@RequestMapping("/rest/api/movies")
public class MovieRestController {

	private final MovieService movieService;

	public MovieRestController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Page<Movie>> getAllMovies(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(defaultValue = "movieName") String sortBy) {
		
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
		return ResponseEntity.ok(movieService.getAllMovies(pageable));
	}

	@GetMapping("/{moviename}")
	public ResponseEntity<Movie> getMovieByMovieName(@PathVariable("moviename") String movieName) {
		Movie movie = movieService.getMovieByMovieName(movieName);
		return movie != null ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Movie> createMovie(@RequestBody MovieDto movieDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
						   .body(movieService.createMovie(movieDto));
	}

}