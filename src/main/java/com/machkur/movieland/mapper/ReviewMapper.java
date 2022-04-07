package com.machkur.movieland.mapper;

import com.machkur.movieland.dto.ReviewWithMovieDto;
import com.machkur.movieland.dto.ReviewWithoutMovieDto;
import com.machkur.movieland.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = UserMapper.class)
public interface ReviewMapper {

    ReviewMapper REVIEW_MAPPER = Mappers.getMapper(ReviewMapper.class);

    ReviewWithoutMovieDto reviewToReviewWithoutMovieDto(Review review);

    Review reviewWithoutMovieDtoToReview(ReviewWithoutMovieDto reviewWithoutMovieDto);

    ReviewWithMovieDto reviewToReviewWithMovieDto(Review review);
}
