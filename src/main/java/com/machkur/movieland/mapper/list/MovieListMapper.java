package com.machkur.movieland.mapper.list;

import com.machkur.movieland.dto.FullMovieDto;
import com.machkur.movieland.dto.SimpleMovieDto;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.mapper.MovieMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = MovieMapper.class)
public interface MovieListMapper {

    MovieListMapper MOVIE_LIST_MAPPER = Mappers.getMapper(MovieListMapper.class);

    Iterable<SimpleMovieDto> movieToSimpleMovieDtos(Iterable<Movie> movies);

    Iterable<Movie> simpleMovieDtoToMovies(Iterable<SimpleMovieDto> simpleMovieDtos);

    Iterable<FullMovieDto> movieToFullMovieDtos(Iterable<Movie> movies);

    Iterable<Movie> fullMovieDtoToMovies(Iterable<FullMovieDto> fullMovieDtos);
}
