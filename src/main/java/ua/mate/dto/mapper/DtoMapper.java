package ua.mate.dto.mapper;

import org.springframework.stereotype.Component;
import ua.mate.dto.UserResponseDto;
import ua.mate.model.User;

@Component
public class DtoMapper {
    public UserResponseDto mapUserToDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setLogin(user.getLogin());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
