package ua.mate.dto;

import lombok.Data;

@Data
public class UserResponseDto {
    private Long id;
    private String login;
    private String password;
}
