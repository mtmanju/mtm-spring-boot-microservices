package com.mtm.examples.repository;

import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

import com.mtm.examples.model.Movie;

public interface MovieRepository extends ReactiveCouchbaseRepository<Movie, String> {
}