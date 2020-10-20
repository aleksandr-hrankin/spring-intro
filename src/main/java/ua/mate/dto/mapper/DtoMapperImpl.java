package ua.mate.dto.mapper;

import ua.mate.dto.UserResponseDto;
import ua.mate.model.User;

public class DtoMapperImpl implements DtoMapper {
    @Override
    public UserResponseDto mapByUser(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
