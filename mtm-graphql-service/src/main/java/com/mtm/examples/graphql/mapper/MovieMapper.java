//package com.mtm.examples.graphql.mapper;
//
//import org.springframework.stereotype.Service;
//
//import com.mtm.examples.graphql.dto.MovieDto;
//import com.mtm.examples.graphql.model.Movie;
//
//import ma.glasnost.orika.MapperFactory;
//import ma.glasnost.orika.impl.ConfigurableMapper;
//
//@Service
//public class MovieMapper extends ConfigurableMapper {
//
//	public void configure(MapperFactory factory) {
//		factory.classMap(Movie.class, MovieDto.class).byDefault().register();
//	}
//
//}