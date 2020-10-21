package ua.mate.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mate.dto.UserResponseDto;
import ua.mate.dto.mapper.DtoMapper;
import ua.mate.model.User;
import ua.mate.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final DtoMapper dtoMapper;

    public UserController(UserService userService, DtoMapper dtoMapper) {
        this.userService = userService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/inject")
    public String save() {
        userService.add(new User("bob", "1234"));
        userService.add(new User("alice", "4321"));
        userService.add(new User("boris", "3412"));
        userService.add(new User("artist", "4123"));
        return "successful";
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return dtoMapper.mapUserToDto(userService.getById(id));
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        return userService.getAll().stream()
                .map(dtoMapper::mapUserToDto)
                .collect(Collectors.toList());
    }
}
