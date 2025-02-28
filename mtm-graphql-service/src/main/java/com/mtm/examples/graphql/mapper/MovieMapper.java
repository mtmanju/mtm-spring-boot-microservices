package com.mtm.examples.graphql.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.mtm.examples.graphql.dto.MovieDto;
import com.mtm.examples.graphql.model.Movie;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MovieMapper {

	MovieDto toDto(Movie movie);
	
	Movie toEntity(MovieDto movieDto);
	
}