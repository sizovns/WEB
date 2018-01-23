package service;

import model.User;

import java.util.List;

public interface UserService {
    User getUser(long id);

    long setUser(User user);

    List<User> getAll();

    void deleteUser(User user);

    void updateUser(User user);
}
