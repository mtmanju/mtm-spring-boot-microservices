package com.mtm.examples.graphql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.repo.MovieRepository;
import com.mtm.examples.graphql.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

//	@Autowired
//	MovieMapper movieMapper;
//
//	@Override
//	public List<MovieDto> getAllMovies() {
//		List<Movie> moviesList = movieRepository.findAll();
//		return movieMapper.mapAsList(moviesList, MovieDto.class);
//	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

}
