package com.machkur.movieland.mapper;

import com.machkur.movieland.dto.UserWithoutReviewsDto;
import com.machkur.movieland.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserWithoutReviewsDto userToUserWithoutReviewsDto(User user);
}
