package com.mtm.examples.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mtm.examples.graphql.model.Movie;
import com.mtm.examples.graphql.repo.MovieRepository;

@SpringBootApplication
public class GraphqlServiceBoot implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlServiceBoot.class, args);
	}

	@Override
	public void run(String... args) {
		List<Movie> movies = new ArrayList<>();
		movies.add(Movie.builder().movieName("Avengers").leadActor("Manju").leadActress("Smita").director("MTM")
				.producer("MT").genre("Action").imdbRating(10.0).build());
		movies.add(Movie.builder().movieName("Avengers2").leadActor("Manju1").leadActress("Smita1").director("MTM")
				.producer("MT1").genre("Comedy").imdbRating(5.0).build());
		movies.add(Movie.builder().movieName("Avengers3").leadActor("Manju2").leadActress("Smita2").director("MTM")
				.producer("MT2").genre("Sci-Fiction").imdbRating(8.0).build());
		movieRepository.saveAll(movies);
	}

}