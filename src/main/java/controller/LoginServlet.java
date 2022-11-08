package controller;

import dao.LoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = LoginDao.login(username, password);
        if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("idUser",user.getIdUser());
            session.setAttribute("nameuser",user.getNameUser());
            session.setAttribute("username",user.getUserName());
            session.setAttribute("password",user.getPassWord());
            session.setAttribute("contact",user.getContact());
            session.setAttribute("address",user.getAddress());
            session.setAttribute("email",user.getEmail());
            session.setAttribute("img",user.getImg());
            session.setAttribute("user",user);

            if (user.getRole() == 1) {
                resp.sendRedirect("/ProductServlet");
            } else {
                resp.sendRedirect("/index.jsp");
            }
        } else {
            resp.sendRedirect("/login");
        }

    }
}