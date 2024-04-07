package com.mtm.examples.reactive.couchbase.repository;

import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

import com.mtm.examples.reactive.couchbase.model.Movie;

public interface MovieRepository extends ReactiveCouchbaseRepository<Movie, String> {
}