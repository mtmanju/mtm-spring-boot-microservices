package com.mtm.examples.graphql.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtm.examples.graphql.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}