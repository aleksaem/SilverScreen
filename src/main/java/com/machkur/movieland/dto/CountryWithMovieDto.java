package com.machkur.movieland.dto;

import lombok.Data;

@Data
public class CountryWithMovieDto {
    private Long id;
    private String name;
    private SimpleMovieDto movie;
}
