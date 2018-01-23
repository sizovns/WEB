package service;

import dao.UserDAOHibernate;
import model.User;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import util.DBHelper;

import java.util.List;

public class UserServiceImplHibernate implements UserService {

    private SessionFactory sessionFactory;
    private static UserServiceImplHibernate instance;

    public static UserServiceImplHibernate getInstance() {
        if (instance == null) {
            instance = new UserServiceImplHibernate();
        }
        return instance;
    }

    private UserServiceImplHibernate() {
        DBHelper dbHelper = DBHelper.getInstance();
        //dbHelper.getMySqlConfigurationHibernate();
        Configuration configuration = dbHelper.getMySqlConfigurationHibernate();
        sessionFactory = DBHelper.createSessionFactory(configuration);
    }

    @Override
    public User getUser(long id) {
        Session session = sessionFactory.openSession();
        UserDAOHibernate dao = new UserDAOHibernate(session);
        User user = dao.getUser(id);
        session.close();
        return user;
    }

    @Override
    public long setUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAOHibernate dao = new UserDAOHibernate(session);
        long id = dao.setUser(user);
        session.close();
        return id;
    }

    @Override
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        UserDAOHibernate dao = new UserDAOHibernate(session);
        List<User> list = dao.getAll();
        session.close();
        return list;
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAOHibernate dao = new UserDAOHibernate(session);
        dao.deleteUser(user);
        session.close();
    }

    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        UserDAOHibernate dao = new UserDAOHibernate(session);
        dao.updateUser(user);
        session.close();
    }
}
