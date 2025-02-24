package com.mtm.examples.graphql.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.exception.DuplicateMovieException;
import com.mtm.examples.graphql.exception.MovieNotFoundException;
import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.repo.MovieRepository;
import com.mtm.examples.graphql.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@CacheConfig(cacheNames = "movies")
public class MovieServiceImpl implements MovieService {

	private final MovieRepository movieRepository;

	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	@Override
	public Page<Movie> getAllMovies(Pageable pageable) {
		log.info("Fetching all movies with pagination");
		return movieRepository.findAll(pageable);
	}

	@Override
	public List<Movie> getAllMovies() {
		log.info("Fetching all movies");
		return movieRepository.findAll();
	}

	@Cacheable(key = "#movieName")
	@Override
	public Movie getMovieByMovieName(String movieName) {
		log.info("Fetching movie by name: {}", movieName);
		if (StringUtils.isBlank(movieName)) {
			throw new IllegalArgumentException("Movie name cannot be empty");
		}
		return movieRepository.findTopByMovieNameIgnoreCase(movieName)
				.orElseThrow(() -> new MovieNotFoundException("Movie not found with name: " + movieName));
	}

	@CacheEvict(allEntries = true)
	@Override
	public Movie createMovie(MovieDto movieDto) {
		log.info("Creating new movie: {}", movieDto.getMovieName());
		if (movieDto == null) {
			throw new IllegalArgumentException("Movie details are required");
		}
		if (movieRepository.existsByMovieNameIgnoreCase(movieDto.getMovieName())) {
			throw new DuplicateMovieException("Movie already exists with name: " + movieDto.getMovieName());
		}
		return movieRepository.save(prepareMovieFromMovieDto(movieDto));
	}

	private Movie prepareMovieFromMovieDto(MovieDto movieDto) {
		return Movie.builder().movieName(movieDto.getMovieName()).leadActor(movieDto.getLeadActor())
				.leadActress(movieDto.getLeadActress()).director(movieDto.getDirector())
				.producer(movieDto.getProducer()).genre(movieDto.getGenre()).imdbRating(movieDto.getImdbRating())
				.build();
	}

}
