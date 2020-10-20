package ua.mate.dto.mapper;

import ua.mate.dto.UserResponseDto;
import ua.mate.model.User;

public interface DtoMapper {
    /**
     * This method accepts a User and writes all his fields to a UserResponseDto.
     *
     * @param user
     * @return UserResponseDto
     */
    UserResponseDto mapByUser(User user);
}
