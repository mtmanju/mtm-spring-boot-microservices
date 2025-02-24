package com.mtm.examples.graphql.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mtm.examples.graphql.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	Optional<Movie> findTopByMovieNameIgnoreCase(String movieName);
	boolean existsByMovieNameIgnoreCase(String movieName);
}