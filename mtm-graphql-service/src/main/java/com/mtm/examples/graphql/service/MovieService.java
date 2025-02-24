package com.mtm.examples.graphql.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;

public interface MovieService {

	Page<Movie> getAllMovies(Pageable pageable);

	List<Movie> getAllMovies();

	Movie getMovieByMovieName(String movieName);

	Movie createMovie(MovieDto movieDto);

}