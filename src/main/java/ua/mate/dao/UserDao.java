package ua.mate.dao;

import java.util.List;
import ua.mate.model.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User getById(Long id);
}
