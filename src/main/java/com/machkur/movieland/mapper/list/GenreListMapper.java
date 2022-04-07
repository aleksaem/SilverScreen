package com.machkur.movieland.mapper.list;

import com.machkur.movieland.dto.GenreWithMovieDto;
import com.machkur.movieland.dto.GenreWithoutMovieDto;
import com.machkur.movieland.entity.Genre;
import com.machkur.movieland.mapper.GenreMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = GenreMapper.class)
public interface GenreListMapper {

    GenreListMapper GENRE_LIST_MAPPER = Mappers.getMapper(GenreListMapper.class);

    Iterable<GenreWithoutMovieDto> genreToGenreWithoutMovieDtos(Iterable<Genre> genres);

    Iterable<GenreWithMovieDto> genreToGenreWithMovieDtos(Iterable<Genre> genres);
}
