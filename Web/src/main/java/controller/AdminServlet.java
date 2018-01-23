package controller;

import dao.UserDAOFactory;
import model.User;
import service.UserService;
import service.UserServiceImpl;
import service.UserServiceImplHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    //private UserServiceImplHibernate userService = UserServiceImplHibernate.getInstance();
    private UserServiceImpl userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.setUser(new User(request.getParameter("name"), request.getParameter("login"), request.getParameter("password")));
        response.sendRedirect("/showAll");
    }
}

