package com.mtm.examples.graphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.repo.MovieRepository;
import com.mtm.examples.graphql.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public Movie getMovieByMovieName(String movieName) {
		return movieRepository.findTopByMovieNameIgnoreCase(movieName);
	}

	@Override
	public Movie createMovie(MovieDto movieDto) {
		if (null == movieDto) {
			throw new RuntimeException("movie details are madatory to create a movie in movie database.");
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
