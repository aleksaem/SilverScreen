package com.machkur.movieland.mapper;

import com.machkur.movieland.dto.FullMovieDto;
import com.machkur.movieland.dto.SimpleMovieDto;
import com.machkur.movieland.entity.Movie;
import com.machkur.movieland.mapper.list.CountryListMapper;
import com.machkur.movieland.mapper.list.GenreListMapper;
import com.machkur.movieland.mapper.list.ReviewListMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {GenreListMapper.class, CountryListMapper.class, ReviewListMapper.class})
public interface MovieMapper {

    MovieMapper MOVIE_MAPPER = Mappers.getMapper(MovieMapper.class);

    SimpleMovieDto movieToSimpleMovieDto(Movie movie);

    Movie simpleMovieDtoToMovie(SimpleMovieDto simpleMovieDto);

    FullMovieDto movieToFullMovieDto(Movie movie);

    Movie fullMovieDtoToMovie(FullMovieDto fullMovieDto);
}
