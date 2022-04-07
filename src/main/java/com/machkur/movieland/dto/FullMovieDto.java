package com.machkur.movieland.dto;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class FullMovieDto {
    private Long id;
    private String russianName;
    private String nativeName;
    private String description;
    private int year;
    private double rating;
    private double price;
    private String picturePath;
    private Set<GenreWithoutMovieDto> genres;
    private Set<CountryWithoutMovieDto> countries;
    private List<ReviewWithoutMovieDto> reviews;
}
