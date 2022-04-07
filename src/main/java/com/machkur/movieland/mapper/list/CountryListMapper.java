package com.machkur.movieland.mapper.list;

import com.machkur.movieland.dto.CountryWithMovieDto;
import com.machkur.movieland.dto.CountryWithoutMovieDto;
import com.machkur.movieland.entity.Country;
import com.machkur.movieland.mapper.CountryMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = CountryMapper.class)
public interface CountryListMapper {

    CountryListMapper COUNTRY_LIST_MAPPER = Mappers.getMapper(CountryListMapper.class);

    Iterable<CountryWithoutMovieDto> countryToCountryWithoutMovieDtos(Iterable<Country> countries);

    Iterable<CountryWithMovieDto> countryToCountryWithMovieDtos(Iterable<Country> countries);
}
