package com.mtm.examples.graphql.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.repo.MovieRepository;
import com.mtm.examples.graphql.service.MovieService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public List<Movie> getAllMovies() {
		log.info("Fetching all movies");
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieByMovieName(String movieName) {
		log.info("Fetching movie by name: {}", movieName);
		return movieRepository.findTopByMovieNameIgnoreCase(movieName);
	}

	@Override
	public Movie createMovie(MovieDto movieDto) {
		log.info("Creating new movie: {}", movieDto.getMovieName());
		return movieRepository.save(prepareMovieFromMovieDto(movieDto));
	}

	private Movie prepareMovieFromMovieDto(MovieDto movieDto) {
		return Movie.builder().movieName(movieDto.getMovieName()).leadActor(movieDto.getLeadActor())
				.leadActress(movieDto.getLeadActress()).director(movieDto.getDirector())
				.producer(movieDto.getProducer()).genre(movieDto.getGenre()).imdbRating(movieDto.getImdbRating())
				.build();
	}

}
