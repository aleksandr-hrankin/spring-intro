package ua.mate.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ua.mate.dao.UserDao;
import ua.mate.model.User;
import ua.mate.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.listUsers();
    }
}
