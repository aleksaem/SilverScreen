package com.machkur.movieland.dto;

import lombok.Data;

@Data
public class ReviewWithoutMovieDto {
    private Long id;
    private String review;
    private UserWithoutReviewsDto user;
}
