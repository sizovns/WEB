package controller;

import model.User;
import service.UserServiceImpl;
import service.UserServiceImplHibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    //private UserServiceImplHibernate userService = UserServiceImplHibernate.getInstance();
    private UserServiceImpl userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUser(Long.parseLong(request.getParameter("id")));
        userService.deleteUser(user);
        response.sendRedirect("/showAll");
    }
}
