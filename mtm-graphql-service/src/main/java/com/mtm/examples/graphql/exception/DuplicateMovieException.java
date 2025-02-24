package com.mtm.examples.graphql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateMovieException extends RuntimeException {

	private static final long serialVersionUID = -5398998398794413134L;

	public DuplicateMovieException(String message) {
		super(message);
	}
}