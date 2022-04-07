package com.machkur.movieland.mapper;

import com.machkur.movieland.dto.GenreWithMovieDto;
import com.machkur.movieland.dto.GenreWithoutMovieDto;
import com.machkur.movieland.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper {

    GenreMapper GENRE_MAPPER = Mappers.getMapper(GenreMapper.class);

    GenreWithoutMovieDto genreToGenreWithoutMovieDto(Genre genre);

    Genre genreWithoutMovieDtoToGenre(GenreWithoutMovieDto genreWithoutMovieDto);

    GenreWithMovieDto genreToGenreWithMovieDto(Genre genre);
}
