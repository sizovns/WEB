package service;

import dao.UserDAOJDBC;
import model.User;
import util.DBHelper;

import java.sql.Connection;
import java.util.List;

public class UserServiceImplJDBC implements UserService {

    private Connection conn;
    private static UserServiceImplJDBC instance;

    public static UserServiceImplJDBC getInstance() {
        if (instance == null) {
            instance = new UserServiceImplJDBC();
        }
        return instance;
    }

    private UserServiceImplJDBC() {
        DBHelper dbHelper = DBHelper.getInstance();
        conn = dbHelper.getMysqlConnectionJDBC();
    }

    @Override
    public User getUser(long id) {
        //Connection conn = dbHelper.getMysqlConnectionJDBC();
        UserDAOJDBC dao = new UserDAOJDBC(conn);
        return dao.getUser(id);
    }

    @Override
    public long setUser(User user) {
        //Connection conn = DBHelper.getMysqlConnectionJDBC();
        UserDAOJDBC dao = new UserDAOJDBC(conn);
        return dao.setUser(user);
    }

    @Override
    public List<User> getAll() {
        //Connection conn = DBHelper.getMysqlConnectionJDBC();
        UserDAOJDBC dao = new UserDAOJDBC(conn);
        return dao.getAll();
    }

    @Override
    public void deleteUser(User user) {
        //Connection conn = DBHelper.getMysqlConnectionJDBC();
        UserDAOJDBC dao = new UserDAOJDBC(conn);
        dao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        //Connection conn = DBHelper.getMysqlConnectionJDBC();
        UserDAOJDBC dao = new UserDAOJDBC(conn);
        dao.updateUser(user);
    }
}
