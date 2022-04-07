package com.machkur.movieland.dto;

import lombok.Data;

@Data
public class ReviewWithMovieDto {
    private Long id;
    private String review;
    private UserWithoutReviewsDto user;
    private SimpleMovieDto movie;
}
