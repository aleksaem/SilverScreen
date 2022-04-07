package com.machkur.movieland.dto;

import lombok.Data;

@Data
public class SimpleMovieDto {
    private Long id;
    private String russianName;
    private String nativeName;
    private String description;
    private int year;
    private double rating;
    private double price;
    private String picturePath;
}
