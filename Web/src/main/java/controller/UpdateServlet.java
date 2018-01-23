package controller;


import model.User;
import service.UserServiceImpl;
import service.UserServiceImplHibernate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    //private UserServiceImplHibernate userService = UserServiceImplHibernate.getInstance();
    private UserServiceImpl userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = userService.getUser(Long.parseLong(request.getParameter("id")));
        user.setLogin(request.getParameter("login"));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));
        userService.updateUser(user);
        response.sendRedirect("/showAll");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user", userService.getUser(Long.parseLong(request.getParameter("id"))));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(request, response);

    }
}
