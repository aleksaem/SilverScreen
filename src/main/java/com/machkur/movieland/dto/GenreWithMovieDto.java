package com.machkur.movieland.dto;

import lombok.Data;

@Data
public class GenreWithMovieDto {
    private Long id;
    private String name;
    private SimpleMovieDto movie;
}
