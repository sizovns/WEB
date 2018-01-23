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
import java.util.List;

@WebServlet("/showAll")
public class ShowAllServlet extends HttpServlet {
    //private UserServiceImplHibernate userService = UserServiceImplHibernate.getInstance();
    private UserServiceImpl userService = new UserServiceImpl();
    private List<User> list;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = userService.getAll();
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(request, response);
    }
}
