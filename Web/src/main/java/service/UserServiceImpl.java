package service;

import dao.UserDAO;
import dao.UserDAOFactory;
import model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDAO dao;

    public UserServiceImpl() {
        UserDAOFactory daoFactory = new UserDAOFactory();
        dao = daoFactory.getDAO();

    }


    @Override
    public User getUser(long id) {
        return dao.getUser(id);
    }

    @Override
    public long setUser(User user) {
        return dao.setUser(user);
    }

    @Override
    public List<User> getAll() {
        return dao.getAll();
    }

    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}
