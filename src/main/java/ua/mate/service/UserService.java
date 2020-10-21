package ua.mate.service;

import java.util.List;
import ua.mate.model.User;

public interface UserService {
    void add(User user);

    User getById(Long id);

    List<User> getAll();
}
