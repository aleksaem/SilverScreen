package com.machkur.movieland.mapper;

import com.machkur.movieland.dto.CountryWithMovieDto;
import com.machkur.movieland.dto.CountryWithoutMovieDto;
import com.machkur.movieland.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper COUNTRY_MAPPER = Mappers.getMapper(CountryMapper.class);

    CountryWithoutMovieDto countryToCountryWithoutMovieDto(Country country);

    Country countryWithoutMovieDtoToCountry(CountryWithoutMovieDto countryWithoutMovieDto);

    CountryWithMovieDto countryToCountryWithMovieDto(Country country);
}
