package com.mtm.examples.reactive.couchbase.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Data
public class Movie {

	@Id
	private String id;

	private String title, genre;

}