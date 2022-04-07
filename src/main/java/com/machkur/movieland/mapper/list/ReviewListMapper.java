package com.machkur.movieland.mapper.list;

import com.machkur.movieland.dto.ReviewWithMovieDto;
import com.machkur.movieland.dto.ReviewWithoutMovieDto;
import com.machkur.movieland.entity.Review;
import com.machkur.movieland.mapper.ReviewMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = ReviewMapper.class)
public interface ReviewListMapper {

    ReviewListMapper REVIEW_LIST_MAPPER = Mappers.getMapper(ReviewListMapper.class);

    Iterable<ReviewWithoutMovieDto> reviewToReviewWithoutMovieDtos(Iterable<Review> reviews);

    Iterable<ReviewWithMovieDto> reviewToReviewWithMovieDtos(Iterable<Review> reviews);
}
